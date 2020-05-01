package ru.geekbrains.shop.jms;

import ru.geekbrains.shop.persist.Product;
import ru.geekbrains.shop.persist.repository.CategoryRepository;
import ru.geekbrains.shop.persist.repository.ProductRepository;
import ru.geekbrains.shop.service.remote.ProductReprRemote;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;


@MessageDriven(activationConfig = {
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
        @ActivationConfigProperty(propertyName = "destination", propertyValue = "java:jboss/exported/jms/queue/productQueue"),
        @ActivationConfigProperty(propertyName = "messageSelector", propertyValue = "action = 'create'")
})
public class JmsProductBean implements MessageListener {

    @EJB
    private ProductRepository productRepository;

    @EJB
    private CategoryRepository categoryRepository;

    @Override
    public void onMessage(Message message) {
        if (message instanceof ObjectMessage) {
            try {
                ProductReprRemote productReprRemote = (ProductReprRemote) ((ObjectMessage) message).getObject();
                productRepository.insert(fromRepr(productReprRemote));
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }
    }

    private Product fromRepr(ProductReprRemote repr) {
        return new Product(
                repr.getId(),
                repr.getName(),
                repr.getDescription(),
                repr.getPrice(),
                categoryRepository.findById(1)
        );
    }

}

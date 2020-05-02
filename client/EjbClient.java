package ru.geekbrains.shop;

import ru.geekbrains.shop.service.remote.ProductServiceRemote;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.io.IOException;
import java.util.Properties;

public class EjbClient {

    private static final String PRODUCT_SERVICE_JNDI_BINDING = "ejb:/java-ee/ProductServiceRemoteImpl!ru.geekbrains.shop.service.remote.ProductServiceRemote";

    public static void main(String[] args) throws IOException, NamingException {
        Context context = createInitialContext();

        ProductServiceRemote repository = (ProductServiceRemote) context.lookup(PRODUCT_SERVICE_JNDI_BINDING);
        repository.findAll().forEach(product -> System.out.printf("%s %s %s %s", product.getId(), product.getName(), product.getDescription(), product.getPrice()));
    }

    public static Context createInitialContext() throws IOException, NamingException {
        final Properties env = new Properties();
        env.load(EjbClient.class.getClassLoader().getResourceAsStream("wildfly-jndi.properties"));
        return new InitialContext(env);
    }
}

import model.Product;
import parserService.HtmlParser;
import parserService.JsonParser;
import parserService.Parser;
import parserService.XmlParser;
import view.Page;
import view.ProductPage;
import view.SimplePage;

import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Parser> parsers = Arrays.asList(new HtmlParser(), new JsonParser(), new XmlParser());
        Page simplePage = new SimplePage("Simple Page Title", "Simple page content");
        List<Product> products = Arrays.asList(
                new Product("0", "Inverter Generator",
                        "Max power: 2kW, nominal power: 1.8kW, fuel tanl volume: 4L", new BitSet(1024)),
                new Product("1", "Async Engine",
                        "Coil type: copper", new BitSet(1024))
        );

        for (Parser render : parsers) {
            System.out.println("Simple page rendering:");
            System.out.println(render.parse(simplePage));
            for (Product product : products) {
                System.out.println("Product " + product.getProductId() + " page rendering:");
                System.out.println(render.parse(new ProductPage(product)));
            }

        }

    }
}
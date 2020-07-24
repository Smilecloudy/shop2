import com.github.pagehelper.Page;
import com.it.entity.Category;
import com.it.entity.Product;
import com.it.service.ProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @auther: 曹云博
 * @create: 2020-06-2020/6/12 15:33
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class ProductTest {
    @Autowired
    private ProductService productService;
    @Test
    public void testFindHotProduct() throws Exception{
        List<Product> hotProduct = productService.findHotProduct();
        for (Product product : hotProduct) {
            System.out.println("product = " + product);
        }
    }

    @Test
    public void testFindNewProduct() throws Exception{
        List<Product> newProduct = productService.findNewProduct();

        for (Product product : newProduct) {
            System.out.println("product = " + product);
        }
    }

    @Test
    public void testFindAllCategory() throws Exception{
       String categories = productService.findAllCategory();
        System.out.println(categories);

    }

    @Test
    public void testFindProductByCid() throws Exception{
        Page<Product> productByCid = (Page<Product>) productService.findProductByCid(2, 1, 3);
        System.out.println(productByCid);

    }

    @Test
    public void testFindProductByPid() throws Exception{
        Product productByPid = productService.findProductByPid(3);
        System.out.println(productByPid);
    }
}

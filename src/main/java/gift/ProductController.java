package gift;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductDao productDao;

    public ProductController(ProductDao productDao) {
        this.productDao = productDao;
    }

    @GetMapping()
    public ResponseEntity<List<Product>> view(Model model) {
        return ResponseEntity.ok().body(productDao.getAllProducts());
    }

    @PostMapping("/new")
    public ResponseEntity<Void> add(@RequestBody Product product) {
        productDao.insert(product);
        return ResponseEntity.ok().build();
    }
}

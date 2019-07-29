package product;

import exceptions.EntityNotFoundByBarcodeException;
import exceptions.ProductNotExistedException;
import org.junit.jupiter.api.*;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class ProductServiceStubImplTest {

    private ProductServiceStubImpl productService = new ProductServiceStubImpl();
    private Product product = new Product(123456779, "Gloves", new BigDecimal(9.99));

    @BeforeEach
    public void clearDb() {
        productService.clear();
    }

    @Nested
    class testDbInitAndGetAll{
        @Test
        public void shouldInitDbWith5Products() throws ProductNotExistedException {
            productService.dbInit();
            int sizeAfterDbInit = 5;

            assertEquals(productService.getAll().size(), sizeAfterDbInit);
        }

        @Test
        public void shouldCheckIfStubIsNotEmpty() throws ProductNotExistedException {
            productService.dbInit();

            assertFalse(productService.getAll().isEmpty());
        }

        @Test
        public void shouldCheckIfDbisEmpty() {
            assertTrue(productService.getAll().isEmpty());
        }

                @Test
        public void addedProductsShouldHaveId() throws ProductNotExistedException {
            productService.dbInit();

            for (int i = 0; i < productService.getAll().size(); i++) {
                System.out.println(productService.getAll().get(i).getId());
                assertNotNull(productService.getAll().get(i).getId());
            }
        }
    }


    @Nested
    class testingAdd {
        @Test
        public void shouldAddProduct() throws ProductNotExistedException {
            int indexOfAddingProduct = productService.getAll().size();

            productService.addProduct(product);

            assertAll(
                    () -> assertEquals(product, productService.getAll().get(indexOfAddingProduct)),
                    () -> assertNotNull(productService.getAll().get(indexOfAddingProduct).getId())
            );
        }

        @Test
        public void shouldntAddNullProduct() {

            Assertions.assertThrows(ProductNotExistedException.class, () -> {
                productService.addProduct(null);
            });
        }
    }


    @Nested
    class testingGetProductByBarcode {
        @Test
        public void shouldGetProductNameByBarcode() throws ProductNotExistedException, EntityNotFoundByBarcodeException {
            productService.dbInit();

            assertEquals("Jeans", productService.getProductByBarcode(123456787).getName());
        }

        @Test
        public void shouldNotGetProductByBarcode_wrongBarcode() throws ProductNotExistedException {
            productService.dbInit();

            Assertions.assertThrows(EntityNotFoundByBarcodeException.class, () -> {
                productService.getProductByBarcode(12345678);
            });
        }

        @Test
        public void shouldNotGetProductByBarcode_barcodeNotInt() throws ProductNotExistedException {
            productService.dbInit();

            Assertions.assertThrows(NumberFormatException.class, () -> {
                productService.getProductByBarcode(Integer.valueOf("kajsdjkjas"));
            });
        }

        @Test
        public void shouldNotGetProductByBarcode_null() throws ProductNotExistedException {
            productService.dbInit();

            Assertions.assertThrows(EntityNotFoundByBarcodeException.class, () -> {
                productService.getProductByBarcode(null);
            });
        }
    }


}
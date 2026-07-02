package tdd.mockito;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class OrderServiceTest {

    @Mock
    private PaymentGateway paymentGatewayMock;

    @InjectMocks
    private OrderService orderService;

    @BeforeEach
    void setUp() {
        // Initialize mock objects annotated with @Mock
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testPlaceOrderSuccess() {
        // Define mock behavior
        when(paymentGatewayMock.processPayment("ORD-101", 2500.00)).thenReturn(true);

        String result = orderService.placeOrder("ORD-101", 2500.00);

        assertEquals("SUCCESS: Order Placed", result);
        // Verify that processPayment was called exactly once with expected arguments
        verify(paymentGatewayMock, times(1)).processPayment("ORD-101", 2500.00);
    }

    @Test
    void testPlaceOrderPaymentDeclined() {
        when(paymentGatewayMock.processPayment("ORD-102", 9999.00)).thenReturn(false);

        String result = orderService.placeOrder("ORD-102", 9999.00);

        assertEquals("FAILED: Payment Declined", result);
        verify(paymentGatewayMock, times(1)).processPayment("ORD-102", 9999.00);
    }
}

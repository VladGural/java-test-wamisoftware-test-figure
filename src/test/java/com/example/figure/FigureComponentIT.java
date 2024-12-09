package com.example.figure;

import com.example.figure.component_test.BaseComponentTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import static com.example.figure.calculate.CalculateClient.*;

@DirtiesContext
@SpringBootTest(
        classes = {
                FigureApplication.class
        },
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
class FigureComponentIT extends BaseComponentTest {
    private static final Logger logger = LoggerFactory.getLogger(FigureComponentIT.class);

    @Test
    void test() throws Exception {
        logger.info("Component test was started");

        calculateSquareProperties(this, 10);

        calculateRectangleProperties(this, 10, 20);

        calculateTriangleProperties(this, 3, 4, 5);

        calculateCircleProperties(this, 1);

        logger.info("Component test successfully passed");
    }

}

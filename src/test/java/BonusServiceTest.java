import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BonusServiceTest {

    @Test
    void shouldCalculateForRegisteredAndUnderLimit() {
        BonusService service = new BonusService();

        // данные
        long amount = 1000;
        boolean registered = true;
        long expected = 30;

        //вызываем метод
        long actual = service.calculate(amount, registered);

        //проводим сравнение
        Assertions.assertEquals(expected, actual);

    }

    @Test
    void shouldCalculateForRegisteredAndOverLimit() {
        BonusService service = new BonusService();

        // данные
        long amount = 1_000_000;
        boolean registered = true;
        long expected = 500;

        //вызываем метод

        long actual = service.calculate(amount, registered);

        //проводим сравнение
        Assertions.assertEquals(expected, actual);
    }

    // Дополнительные тесты - граничные значения для зарегистрированных пользователей

    @Test
        //  рассчитать для зарегистрированных пользователей и суммы при которой бонусы не начисляются.
    void shouldCalculateForRegisteredAndAmountAtWhichBonusesAreNotCredited() {
        BonusService service = new BonusService();

        long amount = 33;
        boolean registered = true;
        long expected = 0;

        long actual = service.calculate(amount, registered);

        Assertions.assertEquals(expected, actual);

    }

    @Test
        // рассчитать для зарегистрированных пользователей и суммы за которую начислят 1 бонус
    void shouldCalculateForRegisteredAndAmountForWhichOneBonusWillBeCredited() {
        BonusService service = new BonusService();

        long amount = 34;
        boolean registered = true;
        long expected = 1;

        long actual = service.calculate(amount, registered);

        Assertions.assertEquals(expected, actual);

    }

    @Test
        // рассчитать для зарегистрированных пользователей и суммы за которую начислят 499 бонусов
    void shouldCalculateForRegisteredAndAmountForWhichFourHundredAndNinetyNineBonusesWillBeCredited() {
        BonusService service = new BonusService();

        long amount = 16666;
        boolean registered = true;
        long expected = 499;

        long actual = service.calculate(amount, registered);

        Assertions.assertEquals(expected, actual);

    }

    @Test
        // рассчитать для зарегистрированных пользователей и минимальной суммы за которую начислят 500 бонусов
    void shouldCalculateForRegisteredAndMinimumAmountForWhichFiveHundredBonusesWillBeCredited() {

        BonusService service = new BonusService();

        long amount = 16667;
        boolean registered = true;
        long expected = 500;

        long actual = service.calculate(amount, registered);

        Assertions.assertEquals(expected, actual);

    }
    // Дополнительные тесты - граничные значения для не зарегистрированных пользователей

    @Test
        // рассчитать для не зарегистрированных пользователей и суммы при которой бонусы не начисляются.
    void shouldCalculateForNotRegisteredAndAmountAtWhichBonusesAreNotCredited() {
        BonusService service = new BonusService();

        long amount = 99;
        boolean registered = false;
        long expected = 0;

        long actual = service.calculate(amount, registered);

        Assertions.assertEquals(expected, actual);

    }

    @Test
        // рассчитать для не зарегистрированных пользователей и суммы за которую начислят 1 бонус
    void shouldCalculateForNotRegisteredAndAmountForWhichOneBonusWillBeCredited() {
        BonusService service = new BonusService();

        long amount = 100;
        boolean registered = false;
        long expected = 1;

        long actual = service.calculate(amount, registered);

        Assertions.assertEquals(expected, actual);

    }

    @Test
        // рассчитать для не зарегистрированных пользователей и суммы за которую начислят 499 бонусов
    void shouldCalculateForNotRegisteredAndAmountForWhichFourHundredAndNinetyNineBonusesWillBeCredited() {
        BonusService service = new BonusService();

        long amount = 49999;
        boolean registered = false;
        long expected = 499;

        long actual = service.calculate(amount, registered);

        Assertions.assertEquals(expected, actual);

    }

    @Test
        // рассчитать для не зарегистрированных пользователей и минимальной суммы за которую начислят 500 бонусов
    void shouldCalculateForNotRegisteredAndMinimumAmountForWhichFiveHundredBonusesWillBeCredited() {
        BonusService service = new BonusService();

        long amount = 50000;
        boolean registered = false;
        long expected = 500;

        long actual = service.calculate(amount, registered);

        Assertions.assertEquals(expected, actual);

    }


}

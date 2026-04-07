import ru.academits.chesnakov.temperature.controller.Controller;
import ru.academits.chesnakov.temperature.model.Converter;
import ru.academits.chesnakov.temperature.model.TemperatureConverter;
import ru.academits.chesnakov.temperature.view.DesktopView;
import ru.academits.chesnakov.temperature.view.View;

public class Main {
    public static void main(String[] args) {
        Converter converter = new TemperatureConverter();
        View view = new DesktopView();
        Controller controller = new Controller(converter, view);
        controller.start();
    }
}

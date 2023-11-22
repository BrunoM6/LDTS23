import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
public class App {
    Board game = new Board(8, 8, 10);
    Terminal terminal = new DefaultTerminalFactory().createTerminal();
    Screen screen = new Screen(terminal);

}

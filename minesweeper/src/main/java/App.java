import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
public class App {
    MinesweeperGame game = new MinesweeperGame(8, 8, 10);
    Terminal terminal = new DefaultTerminalFactory().createTerminal();
    Screen screen = new Screen(terminal);
    while(true){
        game.draw(screen);
        game.handleInput(screen);
    }
}

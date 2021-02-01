package Menu;

import View.MenuView;
import org.junit.jupiter.api.Test;

class MenuViewTest {
    @Test
    public void shouldDisplayMenu(){
        MenuView menuView = new MenuView();
        menuView.displayMenu();
    }
}
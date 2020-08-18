package bean.baseObject;

import bean.game.Type;
import javafx.scene.image.Image;

public final class Iron extends BaseObject {
    @Override
    protected Type setType() {
        return Type.iron;
    }

    public Iron(int x, int y) {
        initElement(new Image("FIle:image/铁.png"), x , y);
    }

}

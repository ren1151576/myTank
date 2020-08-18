package bean.bullet;

import bean.baseObject.BaseObject;
import bean.game.Type;

public class Bullet extends BaseObject {
    @Override
    protected Type setType() {
        return Type.bullet;
    }
}

package repos;

import java.util.List;

public interface Repos<Entity>{
    List<Entity> getAll();
    Entity getById(int id);
    Boolean create(Entity entity);
    Boolean delete(int id);
    Boolean InDB(Entity entity);
}

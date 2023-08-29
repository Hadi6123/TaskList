package tasksByLevel;

public class TaskLevelFacade {

    private int level;

    public TaskLevelFacade(int level){
        this.level = level;
    }

    public OrderByLevel getReleventObject(){
        if (level < 4){
            return new GetEasyTasks();
        } else if (level >= 4 && level <= 7){
            return new GetMediumTasks();
        } else {
            return new GetHardTasks();
        }
    }
}

package factory;

import tasksByLevel.TaskLevelFacade;

public class TaskLevelFactory implements Factory{
    @Override
    public Object span(int level) {
        TaskLevelFacade taskLevelFacade = new TaskLevelFacade(level);
        return taskLevelFacade.getReleventObject();
    }
}

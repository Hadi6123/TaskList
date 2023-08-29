package builders.tasks;

public class TaskDTODataBuilder implements TaskDTOBuilder{

    private String name;
    private int severity;
    private String image;
    private int priority;
    private String description;

    private TaskDTO dto;

    @Override
    public TaskDTOBuilder withName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public TaskDTOBuilder withSeverity(int severity) {
        this.severity = severity;
        return this;
    }

    @Override
    public TaskDTOBuilder withImage(int severityLevel) {

        if (severityLevel >= 4 && severityLevel <= 7){
            image = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS7Nlw5h3rkmTxkZtf7Ezf-V2pEmhwOFY62rw&usqp=CAU";
        } else if (severityLevel > 7 ) {
            image = "https://previews.123rf.com/images/carmenbobo/carmenbobo1502/carmenbobo150200098/36452090-stamp-with-word-hard-inside-vector-illustration.jpg";
        } else {
            image = "https://previews.123rf.com/images/therenderfish/therenderfish1306/therenderfish130600063/20428728-the-word-easy-out-of-green-letter-dices.jpg";
        }
        return this;
    }

    @Override
    public TaskDTOBuilder withPriority(int priority) {
        this.priority = priority;
        return this;
    }

    @Override
    public TaskDTOBuilder withDescription(String description) {
        this.description = description;
        return this;
    }

    @Override
    public TaskDTO build() {
        dto = new TaskDTOData(name, severity, image, priority, description);
        return dto;
    }

    @Override
    public TaskDTO getTaskDTO() {
        return dto;
    }
}

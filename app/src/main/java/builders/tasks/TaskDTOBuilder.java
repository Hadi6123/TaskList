package builders.tasks;

public interface TaskDTOBuilder {

    //methods to build "parts" of product at a time
    TaskDTOBuilder withName(String name) ;

    TaskDTOBuilder withSeverity(int severity);

    TaskDTOBuilder withImage(int severityLevel);

    TaskDTOBuilder withPriority(int priority);

    TaskDTOBuilder withDescription(String description);

    //method to "assemble" final product
    TaskDTO build();
    //(optional) method to fetch already built object
    TaskDTO getTaskDTO();
}

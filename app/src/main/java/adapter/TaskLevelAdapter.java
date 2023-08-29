package adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.taskslist.R;
import com.squareup.picasso.Picasso;

import java.util.List;

import builders.tasks.TaskDTO;
import builders.tasks.model.Task;

public class TaskLevelAdapter extends
        RecyclerView.Adapter<TaskLevelAdapter.ViewHolder>{

    private List<Task> taskList;
    //private void clickListener(ListModel listModel);
    //private Context context;


    public TaskLevelAdapter(List<Task> taskList){

        this.taskList = taskList;
    }

    /*public void setOnClickDeleteItem((ItemModel -> Unit) callback) {
        this.onClickDeleteItem = callback;
    } */

    protected class ViewHolder extends RecyclerView.ViewHolder {
        // Your holder should contain a member variable
        // for any view that will be set as you render a row
        public TextView identification;
        public TextView level;
        public TextView importance;
        public TextView info;

        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each subview
        public ViewHolder(View itemView) {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            super(itemView);

            identification = (TextView) itemView.findViewById(R.id.taskId);
            level = (TextView) itemView.findViewById(R.id.taskLevel);
            importance = itemView.findViewById(R.id.taskPriority);
            info = itemView.findViewById(R.id.taskDescription);

        }
    }

    @NonNull
    @Override
    public TaskLevelAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View contactView = inflater.inflate(R.layout.task_model, parent, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(contactView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull TaskLevelAdapter.ViewHolder holder, int position) {

        Task taskDTO = taskList.get(position);

        //Cart model = listModelList.get(position);


        holder.identification.setText(taskDTO.getName());
        holder.level.setText("Severity: " + Integer.toString(taskDTO.getServerity())+"/10");
        holder.importance.setText("Priority: " + Integer.toString(taskDTO.getPriority()));
        holder.info.setText("Description: " + taskDTO.getDescription());


    }

    @Override
    public int getItemCount() {
        return taskList.size();
    }
}

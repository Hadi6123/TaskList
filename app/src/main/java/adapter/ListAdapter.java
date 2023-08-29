package adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.taskslist.R;
import com.example.taskslist.ViewSpecificTask;
import com.squareup.picasso.Picasso;
import java.text.DecimalFormat;
import java.util.List;

import builders.tasks.TaskDTO;
import builders.tasks.TaskDTOData;
import builders.tasks.model.Task;
import observerTask.Observer;
import observerTask.ObserverImpl;
import observerTask.Subject;
import observerTask.SubjectImpl;

public class ListAdapter extends
        RecyclerView.Adapter<ListAdapter.ViewHolder>{

    private List<TaskDTOData> taskList;
    private Context context;
    //private void clickListener(ListModel listModel);
    //private Context context;


    public ListAdapter(List<TaskDTOData> taskList, Context context){
        this.taskList = taskList;
        this.context = context;
    }

    /*public void setOnClickDeleteItem((ItemModel -> Unit) callback) {
        this.onClickDeleteItem = callback;
    } */

    protected class ViewHolder extends RecyclerView.ViewHolder {
        // Your holder should contain a member variable
        // for any view that will be set as you render a row
        public TextView identification;
        public TextView tasksImportance;
        public TextView tasksDescription;
        public TextView level;
        public ImageView image;
        public Button updateButton;

        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each subview
        public ViewHolder(View itemView) {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            super(itemView);

            identification = (TextView) itemView.findViewById(R.id.itemId);
            tasksImportance = itemView.findViewById(R.id.priority);
            tasksDescription = itemView.findViewById(R.id.description);

            level = (TextView) itemView.findViewById(R.id.severity);
            image = (ImageView) itemView.findViewById(R.id.imageView);
            updateButton = (Button) itemView.findViewById(R.id.btnUpdate);


        }

        public void selectedItem(int pos){
            updateButton.setOnClickListener(view -> {

                Observer observer = ObserverImpl.getInstance();
                Subject subject = SubjectImpl.getInstance();

                observer.setSubject(subject);
                subject.register(observer);

                subject.postTask(taskList.get(pos));

                context.startActivity(new Intent(context, ViewSpecificTask.class));

                /*context.startActivity(new Intent(context, ViewSpecificTask.class).putExtra("id",
                        taskList.get(pos).getId()
                        ) ); */

            });
        }
    }

    @NonNull
    @Override
    public ListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View contactView = inflater.inflate(R.layout.item_model, parent, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(contactView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ListAdapter.ViewHolder holder, int position) {

        TaskDTO taskDTO = taskList.get(position);

        //Cart model = listModelList.get(position);


        holder.identification.setText(taskDTO.getName());
        holder.level.setText("Severity: " + Integer.toString(taskDTO.getSeverity())+"/10");
        holder.tasksImportance.setText("Priority: " + Integer.toString(taskDTO.getPriority()));
        holder.tasksDescription.setText("Description: "+ taskDTO.getDescription());


        Picasso.get().load(taskDTO.getImage()).into(holder.image);

        //holder.

        holder.selectedItem(position);

        /*holder.itemView.findViewById(R.id.btnadd).setOnClickListener(view -> {
            interestedItems.setNewItem(model);
        }); */


            /*
            val logoLinks = mutableMapOf<String, String>(
                "walmart" to "https://cdn.mos.cms.futurecdn.net/5StAbRHLA4ZdyzQZVivm2c-970-80.jpg.webp",
                "sobeys" to "https://upload.wikimedia.org/wikipedia/en/thumb/4/4f/Sobeys_logo.svg/1200px-Sobeys_logo.svg.png",
                "costco" to "https://p.kindpng.com/picc/s/146-1462162_empowering-marginalized-youth-in-the-outdoors-costco-high.png",
                "home depot" to "https://www.pngmart.com/files/16/Home-Depot-Logo-PNG-Photos.png",
                "best buy" to "https://corporate.bestbuy.com/wp-content/uploads/2018/05/2018_rebrand_blog_logo_LEAD_ART.jpg",
                "canadian tire" to "https://s22.q4cdn.com/405442328/files/design/CT-Brandmark-Standard-Secondary-RGW-POS-RGB.png",
                "superstore" to "https://upload.wikimedia.org/wikipedia/commons/8/8a/Real_Canadian_Superstore_logo.png",
                "real canadian superstore" to "https://upload.wikimedia.org/wikipedia/commons/8/8a/Real_Canadian_Superstore_logo.png",
                "canadian superstore" to "https://upload.wikimedia.org/wikipedia/commons/8/8a/Real_Canadian_Superstore_logo.png",
                "loblaws" to "https://creditlandingshoppingcentre.com/wp-content/uploads/2017/10/MASTER-RESIZED-LOGOS-Loblaws.jpg",
                "independent" to "https://www.tremblettsyig.com/images/Tremblett-Independent-Logo.png",
                "lowe's" to "https://logos-world.net/wp-content/uploads/2021/03/Lowes-Logo-700x394.png",
                "lowes" to "https://logos-world.net/wp-content/uploads/2021/03/Lowes-Logo-700x394.png",
                "nofrills" to "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTb7iBwmK6KyMubcwgngLLqd1ZUJI4wMJM7_pVub7FrSm71JvWT9FvtWKVW-iDJOY8ZBlE&usqp=CAU",
                "no frills" to "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTb7iBwmK6KyMubcwgngLLqd1ZUJI4wMJM7_pVub7FrSm71JvWT9FvtWKVW-iDJOY8ZBlE&usqp=CAU",
                "amazon" to "http://media.corporate-ir.net/media_files/IROL/17/176060/Oct18/Amazon%20logo.PNG",
                "rona" to "https://www.rona.ca/wcsstore/RONAStorefrontAssetStore/images/RONA_facebook_share.jpg",
                "freshco" to "http://images.pitchero.com/club_sponsors/17362/1557673930_large.jpg",
                "fresh co" to "http://images.pitchero.com/club_sponsors/17362/1557673930_large.jpg",
                "metro" to "https://torontoguardian.com/wp-content/uploads/2017/06/Metro-Logo.jpg",
                "farm boy" to "https://upload.wikimedia.org/wikipedia/en/thumb/7/77/Farm_Boy_logo.svg/330px-Farm_Boy_logo.svg.png",
                "farmboy" to "https://upload.wikimedia.org/wikipedia/en/thumb/7/77/Farm_Boy_logo.svg/330px-Farm_Boy_logo.svg.png") */

            /*
            Picasso.get().load(logoLinks.get(storeTv.text.toString().toLowerCase())).networkPolicy(
                NetworkPolicy.OFFLINE).into(logo) */

        //Picasso.get().load(logoLinks.get(model.getType())).into(logo)
                /*
        holder.addButton.setOnClickListener{
            onClickDeleteItem?.invoke(ItemModel(model.getId(), nameTv.text.toString(), storeTv.text.toString(), typeTv.text.toString(), model.getPrice()))
        } */
    }

    @Override
    public int getItemCount() {
        return taskList.size();
    }
}
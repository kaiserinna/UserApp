package fi.punakorpi.userapp;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

//tää työntää ne oikeat userin tiedot sinne viewiin, tää käyttää tota meidän just tekemää UsersViewHolder luokkaa, joka just ehtiin.
public class UserListAdapter extends RecyclerView.Adapter<UsersViewHolder> {
    private Context context;

    public UserListAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public UsersViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new UsersViewHolder(LayoutInflater.from(context).inflate(R.layout.item_view, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull UsersViewHolder holder, int position) {
        User user = UserStorage.getInstance().getUser(position);
        holder.textFirstName.setText(user.getFirstName());
        holder.textLastName.setText(user.getLastName());
        holder.textEmail.setText(user.getEmail());
        holder.textDegreeProgram.setText(user.getDegreeProgram());
        holder.textDegree.setText(user.getDegree());
    }

    @Override
    public int getItemCount() {
        return UserStorage.getInstance().getSize();
    }
}

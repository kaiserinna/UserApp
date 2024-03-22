package fi.punakorpi.userapp;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class UsersViewHolder extends RecyclerView.ViewHolder {
    public TextView textFirstName;
    public TextView textLastName;
    public TextView textEmail;
    public TextView textDegreeProgram;
    public TextView textUserDegrees;


    public UsersViewHolder(@NonNull View itemView) {
        super(itemView);
        textFirstName = itemView.findViewById(R.id.textFirstName);
        textLastName = itemView.findViewById(R.id.textLastName);
        textEmail = itemView.findViewById(R.id.textEmail);
        textDegreeProgram = itemView.findViewById(R.id.textDegreeProgram);
        textUserDegrees = itemView.findViewById((R.id.textDegree));
    }
}

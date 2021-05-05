package io.giodude.atry.Adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import io.giodude.atry.Connection.ApiClient;
import io.giodude.atry.Model.UserModel;
import io.giodude.atry.R;
import io.giodude.atry.View.UserUpdateView;
import io.giodude.atry.View.UserView;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {
    Context context;
    public List<UserModel> data;
    private ArrayAdapter<UserModel> adapter;
    public UserAdapter(Context context, List<UserModel> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View item = layoutInflater.inflate(R.layout.useritem,parent,false);
        ViewHolder viewHolder = new ViewHolder(item);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.f.setText(data.get(position).getFname());
        holder.l.setText(data.get(position).getLname());
        holder.m.setText(data.get(position).getMname());
        holder.i.setText(data.get(position).getId().toString());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String fname = holder.f.getText().toString();
                String mname = holder.m.getText().toString();
                String lname = holder.l.getText().toString();
                String idko = holder.i.getText().toString();

                Intent intent = new Intent(context,UserUpdateView.class);
                intent.putExtra("userid",idko);
                intent.putExtra("firstname",fname);
                intent.putExtra("middlename",mname);
                intent.putExtra("lastname",lname);
                context.startActivity(intent);
            }
        });

        holder.itemView.setOnLongClickListener(v -> {
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
            alertDialogBuilder.setMessage("Are you sure,You wanted to delete");
                    alertDialogBuilder.setPositiveButton("yes",
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface arg0, int arg1) {
//                                        Toast.makeText(context,"You clicked yes button",Toast.LENGTH_LONG).show();
                                    String id = holder.i.getText().toString();
                                    Call<ResponseBody> call = ApiClient.getInstance().getApiInterface().deleteUser(id);
                                    call.enqueue(new Callback<ResponseBody>() {
                                        @Override
                                        public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                                            Log.d("Data","Deleted");

                                        }

                                        @Override
                                        public void onFailure(Call<ResponseBody> call, Throwable t) {

                                        }
                                    });
                                    data.remove(data.get(position));
                                    notifyDataSetChanged();
                                }
                            });

            alertDialogBuilder.setNegativeButton("No",new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });

            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();
            return false;
        });

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView f,m,l,i;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            f = itemView.findViewById(R.id.fn);
            m = itemView.findViewById(R.id.mn);
            l = itemView.findViewById(R.id.ln);
            i = itemView.findViewById(R.id.idea);
        }
    }
}

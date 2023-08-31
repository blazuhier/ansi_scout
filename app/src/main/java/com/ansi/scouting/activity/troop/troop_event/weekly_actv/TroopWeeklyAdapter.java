package com.ansi.scouting.activity.troop.troop_event.weekly_actv;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ansi.scouting.R;
import com.ansi.scouting.activity.troop.troop_event.register_leader.RegisterLeaderActivity;
import com.ansi.scouting.model.data.Challenge;
import com.ansi.scouting.utils.GlobalConstantsExtras;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.squareup.picasso.Picasso;

public class TroopWeeklyAdapter extends FirestoreRecyclerAdapter<Challenge, TroopWeeklyAdapter.ViewHoler> {
    private Context context;

    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirestoreRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public TroopWeeklyAdapter(@NonNull FirestoreRecyclerOptions<Challenge> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull TroopWeeklyAdapter.ViewHoler holder, int position, @NonNull Challenge model) {
        holder.titleActv.setText(model.getTitle());
        holder.dateActv.setText(model.getDate());
        holder.descActv.setText(model.getDescription());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, RegisterLeaderActivity.class);
                intent.putExtra(GlobalConstantsExtras.NUMBER_WEEKLY_ACTIVITY, model.getTitle());
                context.startActivity(intent);
            }
        });
        String imageUri = model.getImg();
        Picasso.with(context).load(imageUri).into(holder.imgActv);
    }

    @NonNull
    @Override
    public TroopWeeklyAdapter.ViewHoler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_weekly_actv, parent, false);
        context = parent.getContext();
        return new TroopWeeklyAdapter.ViewHoler(view);
    }

    public class ViewHoler extends RecyclerView.ViewHolder {

        /**
         * <p>
         * Instancia del ImageView que muestra el logo de la actividad de cada CardView de Actividades semanales.
         * </p>
         */
        ImageView imgActv;

        /**
         * <p>
         * Instancia del TextView que muestra el título de la actividad de cada CardView de Actividades semanales.
         * </p>
         */
        TextView titleActv;

        /**
         * <p>
         * Instancia del TextView que muestra la fecha de la actividad de cada CardView de Actividades semanales.
         * </p>
         */
        TextView dateActv;

        /**
         * <p>
         * Instancia del TextView que muestra la descripción de la actividad de cada CardView de Actividades semanales.
         * </p>
         */
        TextView descActv;

        public View view;


        public ViewHoler(@NonNull View itemView) {
            super(itemView);

            imgActv = itemView.findViewById(R.id.img_actv);
            titleActv = itemView.findViewById(R.id.tv_title_actv);
            dateActv = itemView.findViewById(R.id.tv_date_actv);
            descActv = itemView.findViewById(R.id.tv_desc_actv);
        }
    }
}


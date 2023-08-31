package com.ansi.scouting.activity.troop.troop_event;

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
import com.ansi.scouting.activity.troop.troop_event.challenges.MainActivityChallengues;
import com.ansi.scouting.activity.troop.troop_event.challenges.TroopClassesActivity;
import com.ansi.scouting.model.data.Event;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.squareup.picasso.Picasso;

public class TroopEventAdapter extends FirestoreRecyclerAdapter<Event, TroopEventAdapter.ViewHoler> {
    private Context context;
    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirestoreRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public TroopEventAdapter(@NonNull FirestoreRecyclerOptions<Event> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHoler holder, int position, @NonNull Event model) {
        holder.titleEvent.setText(model.getName_event());
        holder.dateEvent.setText(model.getDate_start_event());
        holder.campusEvent.setText(model.getCampus_event());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, MainActivityChallengues.class);
                context.startActivity(intent);
            }
        });
        String imageUri = model.getLogo();
        Picasso.with(context).load(imageUri).into(holder.imgEvent);
    }

    @NonNull
    @Override
    public ViewHoler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_event, parent, false);
        context = parent.getContext();
        return new ViewHoler (view);
    }

    public class ViewHoler extends RecyclerView.ViewHolder{

        /**
         * <p>
         * Instancia del ImageView que muestra el logo del evento de cada CardView de Eventos.
         * </p>
         */
        ImageView imgEvent;

        /**
         * <p>
         * Instancia del TextView que muestra el título del evento de cada CardView de Eventos.
         * </p>
         */
        TextView titleEvent;

        /**
         * <p>
         * Instancia del TextView que muestra la fecha del evento de cada CardView de Eventos.
         * </p>
         */
        TextView dateEvent;

        /**
         * <p>
         * Instancia del TextView que muestra la sede del evento de cada CardView de Eventos.
         * </p>
         */
        TextView campusEvent;

        public View view;


        public ViewHoler(@NonNull View itemView) {
            super(itemView);

            imgEvent = itemView.findViewById(R.id.img_event);
            titleEvent = itemView.findViewById(R.id.tv_title_event);
            dateEvent = itemView.findViewById(R.id.tv_date_event);
            campusEvent = itemView.findViewById(R.id.tv_campus_event);

            itemView.setOnClickListener(v -> Toast.makeText(v.getContext(), "My Item position: " + getAdapterPosition(), Toast.LENGTH_SHORT).show());
        }
    }
}

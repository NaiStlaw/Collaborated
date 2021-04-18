package com.example.covitrix;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerView_Config {
    private Context mContext;
    private SensorAdapter mSensorAdapter;
    public  void  setConfig(RecyclerView recyclerView, Context context, List<Sensor> Sensors, List<String> keys){
        mContext=context;
        mSensorAdapter = new SensorAdapter(Sensors, keys);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(mSensorAdapter);

    }
    class  SensorItemView extends RecyclerView.ViewHolder{

        private TextView mTime;
        private TextView mTemp;
        private TextView mHeartRate;
        private TextView mSPO2;
        private String key;
        public SensorItemView(ViewGroup parent) {
            super(LayoutInflater.from(mContext).inflate(R.layout.activity_main,parent,false));
//            super(LayoutInflater.from(mContext).inflate(R.layout.sensor_list_data, parent, false));
            mTemp = itemView.findViewById(R.id.temp);
            mTime = itemView.findViewById(R.id.time);
            mHeartRate = itemView.findViewById(R.id.BPM);
            mSPO2 = itemView.findViewById(R.id.SPO2);
        }
        public void bind(Sensor sensor, String key){
            mSPO2.setText(sensor.getSPO2());
            mHeartRate.setText(sensor.getHeartRate());
            mTime.setText(sensor.getTimeDate());
            mTemp.setText(sensor.getTemperature());
            this.key = key;
        }



        }
    class SensorAdapter extends  RecyclerView.Adapter<SensorItemView>{
        private List<Sensor> mSensorList;
        private  List<String> mKeys;

        @NonNull
        @Override
        public SensorItemView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new SensorItemView(parent);
        }

        @Override
        public void onBindViewHolder(@NonNull SensorItemView holder, int position) {
            holder.bind(mSensorList.get(position), mKeys.get(position));
        }

        @Override
        public int getItemCount() {
            return mSensorList.size();
        }

        public SensorAdapter(List<Sensor> mSensorList, List<String> mKeys) {
            this.mSensorList = mSensorList;
            this.mKeys = mKeys;
        }

    }

}


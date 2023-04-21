package com.example.pract5.ui.fragments;

import static java.net.Proxy.Type.HTTP;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;

import com.example.pract5.CalOpt;
import com.example.pract5.R;
import com.example.pract5.databinding.FragCalBinding;

public class CalFrag extends Fragment {
    private FragCalBinding binding;

    private static final String CHANNEL_ID = "calendar";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragCalBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        createNotificationChannel();

        binding.notifyBtn.setOnClickListener(view1 -> {
            showNotification();

            Intent intent = new Intent(requireContext(), CalOpt.class);
            requireActivity().startService(intent);
        });
        binding.shareBtn.setOnClickListener(view1 -> {
            Intent textIntent = new Intent(Intent.ACTION_SEND);
            textIntent.setType("text/plain");
            textIntent.putExtra(Intent.EXTRA_TEXT, "Присоединяйтесь к Журналу");
            requireActivity().startActivity(textIntent);
        });
    }


    private void showNotification() {
        Notification notification = new NotificationCompat.Builder(requireContext(), CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_calendar)
                .setContentText("Вы будете перенаправлены на страницу предмета")
                .setContentTitle("Успешно")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .build();

        NotificationManager notificationManager =
                (NotificationManager) requireContext().getSystemService(Context.NOTIFICATION_SERVICE);

        notificationManager.notify(1, notification);

    }

    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(
                    CHANNEL_ID,
                    "calendar",
                    NotificationManager.IMPORTANCE_DEFAULT
            );

            NotificationManager notificationManager =
                    (NotificationManager) requireContext().getSystemService(Context.NOTIFICATION_SERVICE);
            notificationManager.createNotificationChannel(channel);
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        binding = null;
    }
}

package studio.eyesthetics.soundrecorder.adapters;

import android.support.v7.widget.RecyclerView;
import studio.eyesthetics.soundrecorder.listeners.OnDatabaseChangedListener;

public class FileViewerAdapter extends RecyclerView.Adapter<FileViewerAdapter>.RecordingsViewHolder implements OnDatabaseChangedListener {
    private static final String LOG_TAG = "FileViewerAdapter";

    private DBHelper mDatabase;
}

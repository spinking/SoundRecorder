package studio.eyesthetics.soundrecorder.fragments;

import android.os.Bundle;
import android.os.FileObserver;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.io.File;

import studio.eyesthetics.soundrecorder.R;

public class FileViewerFragment extends Fragment {
    private static final String ARG_POSITION = "position";
    private static final String LOG_TAG = "FileViewerFragment";

    private int position;
    private FileViewerAdapter mFileViewerAdapter;

    public static FileViewerFragment newInstance(int position) {
        FileViewerFragment f = new FileViewerFragment();
        Bundle b = new Bundle();
        b.putInt(ARG_POSITION, position);
        f.setArguments(b);

        return f;
    }

    @Override
    public void onCreate(Bundle savedInstancesState) {
        super.onCreate(savedInstancesState);
        position = getArguments().getInt(ARG_POSITION);
        observer.startWatching();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_file_viewer, container, false);

        RecyclerView mRecyclerview = (RecyclerView) v.findViewById(R.id.recyclerView);
        mRecyclerview.setHasFixedSize(true);
        LinearLayoutManager lim = new LinearLayoutManager(getActivity());
        lim.setOrientation(LinearLayoutManager.VERTICAL);

        //newest to oldest order (database stores from oldest to newest)
        lim.setReverseLayout(true);
        lim.setStackFromEnd(true);

        mRecyclerview.setLayoutManager(lim);
        mRecyclerview.setItemAnimator(new DefaultItemAnimator());

        mFileViewerAdapter = new FileViewerAdapter(getActivity(), lim);
        mRecyclerview.setAdapter(mFileViewerAdapter);

        return v;
    }

    FileObserver observer = new FileObserver(android.os.Environment.getExternalStorageDirectory().toString() + "/SoundRecorder") {
        @Override
        public void onEvent(int event, String file) {
            if(event == FileObserver.DELETE) {
                String filePath = android.os.Environment.getExternalStorageDirectory().toString() + "/SoundRecorder" + file + "]";

                Log.d(LOG_TAG, "File deleted [" + android.os.Environment.getExternalStorageDirectory().toString() + "/SoundRecorder" + file + "]");

                mFileViewerAdapter.removeOutOfApp(filePath);
            }
        }

    };

}

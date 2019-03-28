package studio.eyesthetics.soundrecorder.fragments;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;

public class LicensesFragment extends DialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        LayoutInflater dialogInflater = getActivity().getLayoutInflater();
        View openSourceLicensesview = dialogInflater.inflate(R.layout.fragment_licenses, null);

        AlertDialog.Bulider dialogBuilder = new AlertDialog.Builder(getActivity());
        dialogBuilder.setView(openSourceLicensesview)
                .setTitle(getString(R.string.dialog_title_licenses)))
                .setNeutralButton(android.R.string.ok, null);

        return dialogBuilder.create();
    }
}

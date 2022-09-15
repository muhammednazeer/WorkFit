package com.aurosaswatraj.countmycrunch.Dialogs;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;

import com.aurosaswatraj.countmycrunch.manuals.UserManual;
import com.crowdfire.cfalertdialog.CFAlertDialog;

public class UserManualDialog {


     public void showDialog(Context context){
        // Create Alert using Builder
         Intent i =new Intent(context, UserManual.class);
        CFAlertDialog.Builder builder = new CFAlertDialog.Builder(context)
                .setDialogStyle(CFAlertDialog.CFAlertStyle.BOTTOM_SHEET)
                .setTitle("User Guide")
                .setCancelable(true)
                .setDialogBackgroundColor(Color.WHITE)


                .addButton("About WorkFit", Color.WHITE, Color.parseColor("#301934"), CFAlertDialog.CFAlertActionStyle.POSITIVE, CFAlertDialog.CFAlertActionAlignment.JUSTIFIED, (dialog, which) -> {
                    String strName = "One of the emerging apps is Fitness apps. " +
                            "These apps can be used anywhere at any time for getting fit." +
                            " They have now become a perfect solution for those people" +
                            " having busy lives. Most people are relying on these apps since" +
                            " they provide easy access to them at any time. " +
                            "Apps can help in setting fitness goals, providing workout ideas," +
                            " tracking calories intake fitness recipes, and providing " +
                            "progress charts.";
                    i.putExtra("STRING_I_NEED", strName);
                    context.startActivity(i);
                    dialog.dismiss();
                })

                .addButton("BMI Calculator", Color.WHITE, Color.BLACK, CFAlertDialog.CFAlertActionStyle.POSITIVE, CFAlertDialog.CFAlertActionAlignment.JUSTIFIED, (dialog, which) -> {
                    String strName = "https://countmycrunch.netlify.app/bmicalc";
                    i.putExtra("STRING_I_NEED", strName);
                    context.startActivity(i);
                    dialog.dismiss();
                })

                .addButton("Calorie Counter", Color.WHITE, Color.BLACK, CFAlertDialog.CFAlertActionStyle.POSITIVE, CFAlertDialog.CFAlertActionAlignment.JUSTIFIED, (dialog, which) -> {
                    String strName = "https://countmycrunch.netlify.app/caloriecalc.html";
                    i.putExtra("STRING_I_NEED", strName);
                    context.startActivity(i);
                    dialog.dismiss();
                })

                .addButton("Fitness Channel", Color.WHITE, Color.parseColor("#023020"), CFAlertDialog.CFAlertActionStyle.POSITIVE, CFAlertDialog.CFAlertActionAlignment.JUSTIFIED, (dialog, which) -> {
                    String strName = "https://www.youtube.com/channel/UCXIJ2-RSIGn53HA-x9RDevA";
                    i.putExtra("STRING_I_NEED", strName);
                    context.startActivity(i);
                    dialog.dismiss();
                })
            .addButton("Cancel", Color.WHITE, Color.GRAY, CFAlertDialog.CFAlertActionStyle.NEGATIVE, CFAlertDialog.CFAlertActionAlignment.CENTER, (dialog, which) -> {

             dialog.dismiss();
         })
                .setCornerRadius(50.0f);


// Show the alert
        builder.show();
    }
}

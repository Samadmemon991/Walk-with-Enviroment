package com.capstone.objdetection;


import android.os.Build;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.widget.TextView;

import java.util.Hashtable;
import java.util.Map;

public class EnvironmentDetector {
    Vibrator vib;
    TextView objTv, envTv;
    Hashtable<String, Integer> envTable = new Hashtable<>();

    EnvironmentDetector() {
    }

    EnvironmentDetector(Vibrator vib) {

        this.vib = vib;
//        this.objTv = objTv;
//        this.envTv = envTv;
        envTable.put("Room", 0);
        envTable.put("Garage", 0);
        envTable.put("Kitchen", 0);
        envTable.put("Office", 0);
    }

    void ObjCounter(String obj) {
        switch (obj) {
            case "person":
                envTable.merge("Room", 1, Integer::sum);
                envTable.merge("Kitchen", 1, Integer::sum);
                envTable.merge("Office", 1, Integer::sum);
                envTable.merge("Garage", 1, Integer::sum);
                break;

            case "bicycle":
                envTable.merge("Garage", 1, Integer::sum);
                envTable.merge("Garage", 1, Integer::sum);
                break;

            case "car":
                envTable.merge("Garage", 1, Integer::sum);
                envTable.merge("Garage", 1, Integer::sum);
                break;

            case "motorcycle":
                envTable.merge("Garage", 1, Integer::sum);
                envTable.merge("Garage", 1, Integer::sum);
                break;

            case "fire hydrant":
                envTable.merge("Kitchen", 1, Integer::sum);
                envTable.merge("Office", 1, Integer::sum);
                break;

            case "bird":
                envTable.merge("Garage", 1, Integer::sum);
                break;

            case "cat":
                envTable.merge("Room", 1, Integer::sum);
                envTable.merge("Garage", 1, Integer::sum);
                break;

            case "dog":
                envTable.merge("Room", 1, Integer::sum);
                envTable.merge("Garage", 1, Integer::sum);
                break;

            case "backpack":
                envTable.merge("Room", 1, Integer::sum);
                break;

            case "umbrella":
                envTable.merge("Room", 1, Integer::sum);
                envTable.merge("Kitchen", 1, Integer::sum);
                envTable.merge("Garage", 1, Integer::sum);
                envTable.merge("Office", 1, Integer::sum);
                break;

            case "handbag":
                envTable.merge("Kitchen", 1, Integer::sum);
                envTable.merge("Office", 1, Integer::sum);
                envTable.merge("Room", 1, Integer::sum);
                break;

            case "tie":
                envTable.merge("Room", 1, Integer::sum);
                envTable.merge("Office", 1, Integer::sum);
                break;

            case "suitcase":
                envTable.merge("Room", 1, Integer::sum);
                envTable.merge("Office", 1, Integer::sum);
                break;

            case "bottle":
                envTable.merge("Room", 1, Integer::sum);
                envTable.merge("Kitchen", 1, Integer::sum);
                break;

            case "wine glass":
                envTable.merge("Kitchen", 1, Integer::sum);
                envTable.merge("Room", 1, Integer::sum);
                break;

            case "cup":
                envTable.merge("Kitchen", 1, Integer::sum);
                envTable.merge("Room", 1, Integer::sum);
                break;

            case "fork":
                envTable.merge("Kitchen", 1, Integer::sum);
                envTable.merge("Room", 1, Integer::sum);
                break;

            case "knife":
                envTable.merge("Kitchen", 1, Integer::sum);
                envTable.merge("Room", 1, Integer::sum);
                break;

            case "spoon":
                envTable.merge("Kitchen", 1, Integer::sum);
                envTable.merge("Room", 1, Integer::sum);
                break;

            case "bowl":
                envTable.merge("Kitchen", 1, Integer::sum);
//                envTable.merge("Room", 1, Integer::sum);
                break;

            case "banana":
                envTable.merge("Kitchen", 1, Integer::sum);
                envTable.merge("Room", 1, Integer::sum);
                break;

            case "apple":
                envTable.merge("Kitchen", 1, Integer::sum);
                envTable.merge("Room", 1, Integer::sum);
                break;

            case "sandwich":
                envTable.merge("Kitchen", 1, Integer::sum);
                envTable.merge("Room", 1, Integer::sum);
                break;

            case "orange":
                envTable.merge("Kitchen", 1, Integer::sum);
                envTable.merge("Room", 1, Integer::sum);
                break;

            case "broccoli":
                envTable.merge("Kitchen", 1, Integer::sum);
                break;

            case "carrot":
                envTable.merge("Kitchen", 1, Integer::sum);
                break;

            case "hot dog":
                envTable.merge("Kitchen", 1, Integer::sum);
                envTable.merge("Room", 1, Integer::sum);
                break;

            case "pizza":
                envTable.merge("Kitchen", 1, Integer::sum);
                envTable.merge("Room", 1, Integer::sum);
                break;

            case "donut":
                envTable.merge("Kitchen", 1, Integer::sum);
                envTable.merge("Room", 1, Integer::sum);
                break;

            case "cake":
                envTable.merge("Kitchen", 1, Integer::sum);
                envTable.merge("Room", 1, Integer::sum);
                break;

            case "chair":
                envTable.merge("Room", 1, Integer::sum);
                envTable.merge("Office", 1, Integer::sum);
                break;

            case "couch":
                envTable.merge("Room", 1, Integer::sum);
                break;

            case "potted plant":
                envTable.merge("Room", 1, Integer::sum);
                envTable.merge("Office", 1, Integer::sum);
                break;

            case "bed":
                envTable.merge("Room", 1, Integer::sum);
                envTable.merge("Room", 1, Integer::sum);
                break;

            case "tv":
                envTable.merge("Room", 1, Integer::sum);
                break;

            case "laptop":
                envTable.merge("Room", 1, Integer::sum);
                envTable.merge("Office", 1, Integer::sum);
                break;

            case "mouse":
                envTable.merge("Room", 1, Integer::sum);
                envTable.merge("Office", 1, Integer::sum);
                break;

            case "remote":
                envTable.merge("Room", 1, Integer::sum);
                break;

            case "keyboard":
                envTable.merge("Room", 1, Integer::sum);
                envTable.merge("Office", 1, Integer::sum);
                break;

            case "cell phone":
                envTable.merge("Room", 1, Integer::sum);
                envTable.merge("Office", 1, Integer::sum);
                break;

            case "microwave":
                envTable.merge("Kitchen", 1, Integer::sum);
                envTable.merge("Kitchen", 1, Integer::sum);
                break;

            case "oven":
                envTable.merge("Kitchen", 1, Integer::sum);
                envTable.merge("Kitchen", 1, Integer::sum);
                break;

            case "toaster":
                envTable.merge("Kitchen", 1, Integer::sum);
                envTable.merge("Kitchen", 1, Integer::sum);
                break;

            case "sink":
                envTable.merge("Kitchen", 1, Integer::sum);
                envTable.merge("Kitchen", 1, Integer::sum);
                break;

            case "refrigerator":
                envTable.merge("Kitchen", 1, Integer::sum);
                envTable.merge("Kitchen", 1, Integer::sum);
                break;

            case "book":
                envTable.merge("Room", 1, Integer::sum);
                envTable.merge("Office", 1, Integer::sum);
                break;

            case "clock":
                envTable.merge("Room", 1, Integer::sum);
                envTable.merge("Office", 1, Integer::sum);
                envTable.merge("Kitchen", 1, Integer::sum);
                break;

            case "vase":
                envTable.merge("Room", 1, Integer::sum);
                envTable.merge("Office", 1, Integer::sum);
                break;

            case "scissors":
                envTable.merge("Room", 1, Integer::sum);
                envTable.merge("Office", 1, Integer::sum);
                break;

            case "teddy bear":
                envTable.merge("Room", 1, Integer::sum);
                break;

            case "hair drier":
                envTable.merge("Room", 1, Integer::sum);
                break;

            default:
                break;
        }
    }

    void objCheck(String obj, TextView objTv, TextView envTv) {

        String OldObjs = (String) objTv.getText();
        if (OldObjs.isEmpty()) {
            objTv.setText(obj);
            ObjSet(obj, envTv);
        } else if (!(OldObjs.contains(obj))) {
            objTv.setText(OldObjs + ", " + obj);
            ObjSet(obj, envTv);
        }

//        objTv.append(obj + ", ");

    }

    void ObjSet(String obj, TextView envTv) {
        ObjCounter(obj);
        if (envTable.get("Room") >= 5 || envTable.get("Garage") >= 5
                || envTable.get("Kitchen") >= 5 || envTable.get("Office") >= 5) {
            envTv.setText("Pending");

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                vib.vibrate(VibrationEffect.createOneShot(400, VibrationEffect.DEFAULT_AMPLITUDE));
            } else {
                vib.vibrate(400);
            }

        }
    }


    String envSet(TextView envTv) {
        int maxScore = 0;
        String envS = "";
        for (Map.Entry<String, Integer> m : envTable.entrySet()) {
            if (m.getValue() > maxScore) {
                maxScore = m.getValue();
                envS = m.getKey();
            }
        }
        envTv.setText(envS);
        return envS;
    }
}


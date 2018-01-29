package com.example.dude.remindermain;

import android.content.Context;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by DuDe on 01-01-2018.
 */

public class DataManagement {

    private final String fileName = "TaskFile";
    private String data = "";
    private static int count = 1;
    private String beginToken = "<SOL>";
    private String endToken = "<EOL>";
    private static ArrayList<AddLogicUnit> listArray = new ArrayList<AddLogicUnit>();

    //Constructor loads up data from file
    public DataManagement(Context context){
        data = readData(context);
        if(!data.isEmpty()){
            int index = data.lastIndexOf(beginToken);
            int localCount = Integer.parseInt(data.substring(index - 1,index));
            count = localCount + 1;
            if(listArray.isEmpty())
                parseData();
        }
    }

    public ArrayList<AddLogicUnit> getListArray() {
        if(this.listArray != null)
            return this.listArray;
        else
            return null;
    }

    public String readData(Context context){
        String data = "";
        FileInputStream fileInputStream = null;
        try{
            fileInputStream = context.getApplicationContext().openFileInput(fileName);
            int c;
            while((c=fileInputStream.read()) != -1){
                data += Character.toString((char)c);
            }
            fileInputStream.close();
        } catch (IOException e){
            e.printStackTrace();
        }

        return data;
    }

    public void parseData() {
        String[] rows = this.data.split("\\n");
        for (String row: rows ) {
            AddLogicUnit buffer = convertToObject(row);
            if(buffer != null)
                listArray.add(buffer);
        }
    }

    public void writeData(Context context, String data){
        FileOutputStream fileOutputStream = null;
        try{
            String localData = count + beginToken + data + endToken + "\n";
            fileOutputStream = context.getApplicationContext().openFileOutput(fileName, Context.MODE_APPEND);
            fileOutputStream.write(localData.getBytes());
            fileOutputStream.close();
            this.data += localData;
            count++;
            AddLogicUnit addData = convertToObject(data);
            if(addData != null)
                listArray.add(addData);
        } catch(IOException e){
            e.printStackTrace();
        }
    }

    private AddLogicUnit convertToObject(String line) {
        AddLogicUnit temp = null;
        if(!line.isEmpty()) {
            temp = new AddLogicUnit();
            String[] array = line.split("\\|");
            if(array[0].indexOf(beginToken) != 0)
                temp.setTaskName(array[0]);
            else
                temp.setTaskName(array[0].split(beginToken)[1]);
            temp.setResetFrequency(Integer.parseInt(array[1]));
            temp.setTime(array[2]);
            if(array[3].indexOf(endToken) != 0)
                temp.setTotalTime(array[3]);
            else
                temp.setTotalTime(array[3].split(endToken)[0]);
        }
        return temp;
    }

    public String findData(String index){
        int resultStartIndex = this.data.indexOf(index + beginToken);
        if(resultStartIndex == 0){
            return this.data.substring(5, this.data.indexOf(endToken, resultStartIndex));
        }
        else if(resultStartIndex > -1){
            int resultLastIndex = this.data.indexOf(endToken + resultStartIndex);
            return this.data.substring(resultStartIndex + 4, resultLastIndex);
        }
        return null;
    }

}

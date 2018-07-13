package com.helpers;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Relay {
    // TODO: IP here
    private String base_url = "http://__ip_here__";
    private String getState_url="/sensors_actuators/getRelayStatus/";
    private String setState_url="/sensors_actuators/setRelayStatus/";
    private String reset_url="/sensors_actuators/resetRelays/";
    // TODO: SECRET_KEY here
    private String SECRET_KEY = "__key_here__";

    public StringBuffer buffer;

    private JSONObject createRequest(String relay, boolean state) {
        JSONObject sprinkler = new JSONObject();

        try {
            sprinkler.put("SECRET_KEY", SECRET_KEY);
            if (relay != "") {
                sprinkler.put("Relay", relay);
            sprinkler.put("State", state);
            }
        } catch (JSONException except) {
            except.printStackTrace();
        }

        return sprinkler;
    }

    public String GetState() {
        HttpURLConnection con=null;
        OutputStream os= null;
        String results = null;

        try {
            con = (HttpURLConnection) (new URL(base_url+getState_url).openConnection());
            con.setRequestMethod("POST");
            con.setRequestProperty("Content-Type","application/json");
            con.setDoOutput(true);
            con.connect();

            // send message
            JSONObject obj = createRequest("", false);
            os = con.getOutputStream();
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));
            writer.write(obj.toString());
            writer.flush();
            writer.close();
            os.close();

            // read response
            BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String line = null;
            StringBuffer sb = new StringBuffer();
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }

            reader.close();
            results = sb.toString();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            con.disconnect();
            return results;
        }
    }

    public String SetState(String relay, boolean state) {
        HttpURLConnection con=null;
        OutputStream os= null;
        String results = null;

        try {
            con = (HttpURLConnection) new URL(base_url+setState_url).openConnection();
            con.setRequestMethod("POST");
            con.setRequestProperty("Content-Type", "application/json");
            con.setDoOutput(true);
            con.connect();

            // send message
            JSONObject obj = createRequest(relay, state);
            os = con.getOutputStream();

            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));
            writer.write(obj.toString());
            writer.flush();
            writer.close();
            os.close();

            // read response
            BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String line = null;
            StringBuffer sb = new StringBuffer();
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }

            reader.close();
            results = sb.toString();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            con.disconnect();
            return results;
        }
    }

}

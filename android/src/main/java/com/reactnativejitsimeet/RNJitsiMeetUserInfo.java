package com.reactnativejitsimeet;

import android.os.Bundle;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * This class represents user information to be passed to {@link RNJitsiMeetConferenceOptions} for
 * identifying a user.
 */
public class RNJitsiMeetUserInfo {
    /**
     * User's display name.
     */
    private String displayName;

    /**
     * User's email address.
     */
    private String email;

    /**
     * User's avatar URL.
     */
    private URL avatar;

    private String subject;

    public RNJitsiMeetUserInfo() {}

    public RNJitsiMeetUserInfo(Bundle b) {
        super();

        if (b.containsKey("displayName")) {
            displayName = b.getString("displayName");
        }

        if (b.containsKey("email")) {
            email = b.getString("email");
        }

        if (b.containsKey("avatarURL")) {
            String avatarURL = b.getString("avatarURL");
            try {
                avatar = new URL(avatarURL);
            } catch (MalformedURLException e) {
            }
        }

        if (b.containsKey("subject")) {
            subject = b.getString("subject");
        }
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public URL getAvatar() {
        return avatar;
    }

    public void setAvatar(URL avatar) {
        this.avatar = avatar;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    Bundle asBundle() {
        Bundle b = new Bundle();

        if (displayName != null) {
            b.putString("displayName", displayName);
        }

        if (email != null) {
            b.putString("email", email);
        }

        if (avatar != null) {
            b.putString("avatarURL", avatar.toString());
        }

        if (subject != null) {
            b.putString("subject", subject);
        }

        return b;
    }
}

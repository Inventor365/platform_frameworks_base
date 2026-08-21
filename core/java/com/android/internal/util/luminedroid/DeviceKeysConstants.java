/*
 * SPDX-FileCopyrightText: 2018,2021 The LineageOS Project
 * SPDX-FileCopyrightText: 2026 LumineDroid
 * SPDX-License-Identifier: Apache-2.0
 */

package com.android.internal.util.luminedroid;

import android.content.ContentResolver;
import android.os.UserHandle;
import android.provider.Settings;

public class DeviceKeysConstants {
    // Available custom actions to perform on a key press.
    public enum Action {
        NOTHING,
        MENU,
        APP_SWITCH,
        SEARCH,
        VOICE_SEARCH,
        IN_APP_SEARCH,
        LAUNCH_CAMERA,
        SLEEP,
        LAST_APP,
        SPLIT_SCREEN,
        KILL_APP,
        PLAY_PAUSE_MUSIC,
        TORCH,
        SCREENSHOT,
        PARTIAL_SCREENSHOT,
        VOLUME_PANEL,
        CLEAR_ALL_NOTIFICATIONS,
        NOTIFICATIONS,
        QS_PANEL,
        RINGER_MODES,
        AMBIENT_DISPLAY,
        SYSTEM_POPUP;

        public static Action fromIntSafe(int id) {
            if (id < NOTHING.ordinal() || id >= Action.values().length) {
                return NOTHING;
            }
            return Action.values()[id];
        }

        public static Action fromSettings(ContentResolver cr, String setting, Action def) {
            return fromIntSafe(Settings.System.getIntForUser(cr,
                    setting, def.ordinal(), UserHandle.USER_CURRENT));
        }
    }

    public static final int KEY_MASK_HOME = 0x01;
    public static final int KEY_MASK_BACK = 0x02;
    public static final int KEY_MASK_MENU = 0x04;
    public static final int KEY_MASK_ASSIST = 0x08;
    public static final int KEY_MASK_APP_SWITCH = 0x10;
    public static final int KEY_MASK_CAMERA = 0x20;
    public static final int KEY_MASK_VOLUME = 0x40;
}

package com.coldfriesinoctober.walrus.music;

import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import kotlin.Metadata;

/* compiled from: Spotify.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/coldfriesinoctober/walrus/music/SpotifyAuthState;", "", "()V", "connectedTick", "Landroidx/compose/runtime/MutableIntState;", "getConnectedTick", "()Landroidx/compose/runtime/MutableIntState;", "lastError", "Landroidx/compose/runtime/MutableState;", "", "getLastError", "()Landroidx/compose/runtime/MutableState;", "app_debug"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SpotifyAuthState {
    public static final int $stable = 0;
    public static final SpotifyAuthState INSTANCE = new SpotifyAuthState();
    private static final MutableIntState connectedTick = SnapshotIntStateKt.mutableIntStateOf(0);
    private static final MutableState<String> lastError;

    static {
        MutableState<String> mutableStateOf$default;
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        lastError = mutableStateOf$default;
    }

    private SpotifyAuthState() {
    }

    public final MutableIntState getConnectedTick() {
        return connectedTick;
    }

    public final MutableState<String> getLastError() {
        return lastError;
    }
}

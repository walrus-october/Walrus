package com.coldfriesinoctober.walrus.music;

import android.util.Base64;
import androidx.core.app.NotificationCompat;
import androidx.datastore.preferences.core.Preferences;
import androidx.media3.exoplayer.upstream.CmcdData;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.coldfriesinoctober.walrus.Prefs;
import com.coldfriesinoctober.walrus.music.Spotify;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.Charsets;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlin.text.Typography;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.Dispatchers;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.apache.commons.compress.utils.CharsetNames;
import org.apache.commons.io.IOUtils;
import org.json.JSONObject;
import org.schabi.newpipe.extractor.stream.Stream;

/* compiled from: Spotify.kt */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010%\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001:\u0003TUVB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0004H\u0086@¢\u0006\u0002\u0010\u0012J\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u0004H\u0082@¢\u0006\u0002\u0010\u0016J$\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u00182\u0006\u0010\u0015\u001a\u00020\u0004H\u0082@¢\u0006\u0002\u0010\u0016J*\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00040\u00182\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0004H\u0082@¢\u0006\u0002\u0010\u001cJ\u000e\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u0004J\u000e\u0010\u001f\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u0004J\u0014\u0010!\u001a\b\u0012\u0004\u0012\u00020#0\"2\u0006\u0010$\u001a\u00020\u0004J\u0006\u0010%\u001a\u00020&J\u0014\u0010'\u001a\u00020\u00042\f\u0010(\u001a\b\u0012\u0004\u0012\u00020#0\"J\u001e\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u0004H\u0086@¢\u0006\u0002\u0010\u001cJ\u0010\u0010,\u001a\u0004\u0018\u00010\u0004H\u0086@¢\u0006\u0002\u0010\u0012J\u0014\u0010-\u001a\b\u0012\u0004\u0012\u00020#0\"H\u0086@¢\u0006\u0002\u0010\u0012J\u0006\u0010.\u001a\u00020*J\u0006\u0010/\u001a\u00020*J\u0018\u00100\u001a\u00020*2\u0006\u00101\u001a\u00020\u00192\u0006\u00102\u001a\u00020\u0004H\u0002J\u0012\u00103\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000404J\u0006\u00105\u001a\u00020\u0004J\u0010\u00106\u001a\u00020\u00042\u0006\u00107\u001a\u00020\u0004H\u0002J\u001e\u00108\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00182\u0006\u00109\u001a\u00020\u0004J$\u0010:\u001a\u0010\u0012\u0004\u0012\u00020\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u00182\u0006\u00102\u001a\u00020;H\u0082@¢\u0006\u0002\u0010<J.\u0010=\u001a\u0004\u0018\u00010\u00042\u0006\u0010>\u001a\u00020#2\u0014\b\u0002\u0010?\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000404H\u0086@¢\u0006\u0002\u0010@J\u001c\u0010A\u001a\u00020&2\u0012\u0010?\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040BH\u0002J(\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020\u00042\u0006\u0010F\u001a\u00020\u00042\b\b\u0002\u0010G\u001a\u00020HH\u0086@¢\u0006\u0002\u0010IJ\u001e\u0010J\u001a\u00020K2\u0006\u0010L\u001a\u00020\u00042\u0006\u0010M\u001a\u00020*H\u0086@¢\u0006\u0002\u0010NJ\u0010\u0010O\u001a\u00020&2\u0006\u0010P\u001a\u00020\u0014H\u0002J\u001e\u0010Q\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00040\u0018*\u00020RH\u0082@¢\u0006\u0002\u0010SR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\f\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006W"}, d2 = {"Lcom/coldfriesinoctober/walrus/music/Spotify;", "", "()V", "API", "", "AUTH_URL", "CLIENT_ID", "REDIRECT_URI", "SCOPES", "TOKEN_URL", "http", "Lokhttp3/OkHttpClient;", "pendingVerifier", "getPendingVerifier", "()Ljava/lang/String;", "setPendingVerifier", "(Ljava/lang/String;)V", "accessToken", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "apiGet", "Lorg/json/JSONObject;", "path", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "apiGetStatus", "Lkotlin/Pair;", "", "apiWrite", "method", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "authUrl", "challenge", "challengeFor", "verifier", "decodeLikes", "", "Lcom/coldfriesinoctober/walrus/music/Spotify$SpTrack;", "text", "disconnect", "", "encodeLikes", "list", "exchangeCode", "", "code", "fetchAccountName", "fetchAllLiked", "grantedCanWrite", "isConnected", "isDevModeBlock", NotificationCompat.CATEGORY_STATUS, TtmlNode.TAG_BODY, "loadMap", "", "newVerifier", "norm", CmcdData.Factory.STREAMING_FORMAT_SS, "parseRedirect", "url", "postForm", "Lokhttp3/FormBody;", "(Lokhttp3/FormBody;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resolveVideoId", "t", "map", "(Lcom/coldfriesinoctober/walrus/music/Spotify$SpTrack;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveMap", "", "searchTrack", "Lcom/coldfriesinoctober/walrus/music/Spotify$SearchOutcome;", "title", "artist", "durationMs", "", "(Ljava/lang/String;Ljava/lang/String;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setLiked", "Lcom/coldfriesinoctober/walrus/music/Spotify$WriteResult;", "spTrackId", "like", "(Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "storeTokens", "obj", "awaitBody", "Lokhttp3/Call;", "(Lokhttp3/Call;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "SearchOutcome", "SpTrack", "WriteResult", "app_debug"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class Spotify {
    private static final String API = "https://api.spotify.com/v1";
    private static final String AUTH_URL = "https://accounts.spotify.com/authorize";
    public static final String CLIENT_ID = "2723dc6ecbac48e28949994c3b29d8b7";
    public static final String REDIRECT_URI = "walrus://callback";
    private static final String SCOPES = "user-library-read user-library-modify";
    private static final String TOKEN_URL = "https://accounts.spotify.com/api/token";
    private static volatile String pendingVerifier;
    public static final Spotify INSTANCE = new Spotify();
    private static final OkHttpClient http = new OkHttpClient.Builder().connectTimeout(15, TimeUnit.SECONDS).readTimeout(20, TimeUnit.SECONDS).build();
    public static final int $stable = 8;

    /* compiled from: Spotify.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0005\u0002\u0003\u0004\u0005\u0006\u0082\u0001\u0005\u0007\b\t\n\u000b¨\u0006\f"}, d2 = {"Lcom/coldfriesinoctober/walrus/music/Spotify$SearchOutcome;", "", "DevMode", "Error", "Hit", "NoMatch", "Rejected", "Lcom/coldfriesinoctober/walrus/music/Spotify$SearchOutcome$DevMode;", "Lcom/coldfriesinoctober/walrus/music/Spotify$SearchOutcome$Error;", "Lcom/coldfriesinoctober/walrus/music/Spotify$SearchOutcome$Hit;", "Lcom/coldfriesinoctober/walrus/music/Spotify$SearchOutcome$NoMatch;", "Lcom/coldfriesinoctober/walrus/music/Spotify$SearchOutcome$Rejected;", "app_debug"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface SearchOutcome {

        /* compiled from: Spotify.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000b"}, d2 = {"Lcom/coldfriesinoctober/walrus/music/Spotify$SearchOutcome$DevMode;", "Lcom/coldfriesinoctober/walrus/music/Spotify$SearchOutcome;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_debug"}, k = 1, mv = {1, 9, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public static final /* data */ class DevMode implements SearchOutcome {
            public static final int $stable = 0;
            public static final DevMode INSTANCE = new DevMode();

            private DevMode() {
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof DevMode)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -636092284;
            }

            public String toString() {
                return "DevMode";
            }
        }

        /* compiled from: Spotify.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000b"}, d2 = {"Lcom/coldfriesinoctober/walrus/music/Spotify$SearchOutcome$Error;", "Lcom/coldfriesinoctober/walrus/music/Spotify$SearchOutcome;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_debug"}, k = 1, mv = {1, 9, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public static final /* data */ class Error implements SearchOutcome {
            public static final int $stable = 0;
            public static final Error INSTANCE = new Error();

            private Error() {
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Error)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -200470988;
            }

            public String toString() {
                return "Error";
            }
        }

        /* compiled from: Spotify.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/coldfriesinoctober/walrus/music/Spotify$SearchOutcome$Hit;", "Lcom/coldfriesinoctober/walrus/music/Spotify$SearchOutcome;", "track", "Lcom/coldfriesinoctober/walrus/music/Spotify$SpTrack;", "(Lcom/coldfriesinoctober/walrus/music/Spotify$SpTrack;)V", "getTrack", "()Lcom/coldfriesinoctober/walrus/music/Spotify$SpTrack;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_debug"}, k = 1, mv = {1, 9, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public static final /* data */ class Hit implements SearchOutcome {
            public static final int $stable = 0;
            private final SpTrack track;

            public Hit(SpTrack track) {
                Intrinsics.checkNotNullParameter(track, "track");
                this.track = track;
            }

            public static /* synthetic */ Hit copy$default(Hit hit, SpTrack spTrack, int i, Object obj) {
                if ((i & 1) != 0) {
                    spTrack = hit.track;
                }
                return hit.copy(spTrack);
            }

            /* renamed from: component1, reason: from getter */
            public final SpTrack getTrack() {
                return this.track;
            }

            public final Hit copy(SpTrack track) {
                Intrinsics.checkNotNullParameter(track, "track");
                return new Hit(track);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Hit) && Intrinsics.areEqual(this.track, ((Hit) other).track);
            }

            public final SpTrack getTrack() {
                return this.track;
            }

            public int hashCode() {
                return this.track.hashCode();
            }

            public String toString() {
                return "Hit(track=" + this.track + ")";
            }
        }

        /* compiled from: Spotify.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000b"}, d2 = {"Lcom/coldfriesinoctober/walrus/music/Spotify$SearchOutcome$NoMatch;", "Lcom/coldfriesinoctober/walrus/music/Spotify$SearchOutcome;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_debug"}, k = 1, mv = {1, 9, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public static final /* data */ class NoMatch implements SearchOutcome {
            public static final int $stable = 0;
            public static final NoMatch INSTANCE = new NoMatch();

            private NoMatch() {
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof NoMatch)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -101962320;
            }

            public String toString() {
                return "NoMatch";
            }
        }

        /* compiled from: Spotify.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000b"}, d2 = {"Lcom/coldfriesinoctober/walrus/music/Spotify$SearchOutcome$Rejected;", "Lcom/coldfriesinoctober/walrus/music/Spotify$SearchOutcome;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_debug"}, k = 1, mv = {1, 9, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public static final /* data */ class Rejected implements SearchOutcome {
            public static final int $stable = 0;
            public static final Rejected INSTANCE = new Rejected();

            private Rejected() {
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Rejected)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 63789266;
            }

            public String toString() {
                return "Rejected";
            }
        }
    }

    /* compiled from: Spotify.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J=\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006\u001d"}, d2 = {"Lcom/coldfriesinoctober/walrus/music/Spotify$SpTrack;", "", TtmlNode.ATTR_ID, "", "title", "artist", "durationMs", "", "artUrl", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;)V", "getArtUrl", "()Ljava/lang/String;", "getArtist", "getDurationMs", "()J", "getId", "getTitle", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "app_debug"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* data */ class SpTrack {
        public static final int $stable = 0;
        private final String artUrl;
        private final String artist;
        private final long durationMs;
        private final String id;
        private final String title;

        public SpTrack(String id, String title, String artist, long j, String str) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(artist, "artist");
            this.id = id;
            this.title = title;
            this.artist = artist;
            this.durationMs = j;
            this.artUrl = str;
        }

        public static /* synthetic */ SpTrack copy$default(SpTrack spTrack, String str, String str2, String str3, long j, String str4, int i, Object obj) {
            if ((i & 1) != 0) {
                str = spTrack.id;
            }
            if ((i & 2) != 0) {
                str2 = spTrack.title;
            }
            String str5 = str2;
            if ((i & 4) != 0) {
                str3 = spTrack.artist;
            }
            String str6 = str3;
            if ((i & 8) != 0) {
                j = spTrack.durationMs;
            }
            long j2 = j;
            if ((i & 16) != 0) {
                str4 = spTrack.artUrl;
            }
            return spTrack.copy(str, str5, str6, j2, str4);
        }

        /* renamed from: component1, reason: from getter */
        public final String getId() {
            return this.id;
        }

        /* renamed from: component2, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        /* renamed from: component3, reason: from getter */
        public final String getArtist() {
            return this.artist;
        }

        /* renamed from: component4, reason: from getter */
        public final long getDurationMs() {
            return this.durationMs;
        }

        /* renamed from: component5, reason: from getter */
        public final String getArtUrl() {
            return this.artUrl;
        }

        public final SpTrack copy(String id, String title, String artist, long durationMs, String artUrl) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(artist, "artist");
            return new SpTrack(id, title, artist, durationMs, artUrl);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SpTrack)) {
                return false;
            }
            SpTrack spTrack = (SpTrack) other;
            return Intrinsics.areEqual(this.id, spTrack.id) && Intrinsics.areEqual(this.title, spTrack.title) && Intrinsics.areEqual(this.artist, spTrack.artist) && this.durationMs == spTrack.durationMs && Intrinsics.areEqual(this.artUrl, spTrack.artUrl);
        }

        public final String getArtUrl() {
            return this.artUrl;
        }

        public final String getArtist() {
            return this.artist;
        }

        public final long getDurationMs() {
            return this.durationMs;
        }

        public final String getId() {
            return this.id;
        }

        public final String getTitle() {
            return this.title;
        }

        public int hashCode() {
            return (((((((this.id.hashCode() * 31) + this.title.hashCode()) * 31) + this.artist.hashCode()) * 31) + Long.hashCode(this.durationMs)) * 31) + (this.artUrl == null ? 0 : this.artUrl.hashCode());
        }

        public String toString() {
            return "SpTrack(id=" + this.id + ", title=" + this.title + ", artist=" + this.artist + ", durationMs=" + this.durationMs + ", artUrl=" + this.artUrl + ")";
        }
    }

    /* compiled from: Spotify.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/coldfriesinoctober/walrus/music/Spotify$WriteResult;", "", "(Ljava/lang/String;I)V", "OK", "FAILED", "NEEDS_REAUTH", "DEV_MODE", "app_debug"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public enum WriteResult {
        OK,
        FAILED,
        NEEDS_REAUTH,
        DEV_MODE;

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);

        public static EnumEntries<WriteResult> getEntries() {
            return $ENTRIES;
        }
    }

    private Spotify() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:11:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0060 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object apiGet(java.lang.String r6, kotlin.coroutines.Continuation<? super org.json.JSONObject> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.coldfriesinoctober.walrus.music.Spotify$apiGet$1
            if (r0 == 0) goto L14
            r0 = r7
            com.coldfriesinoctober.walrus.music.Spotify$apiGet$1 r0 = (com.coldfriesinoctober.walrus.music.Spotify$apiGet$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L19
        L14:
            com.coldfriesinoctober.walrus.music.Spotify$apiGet$1 r0 = new com.coldfriesinoctober.walrus.music.Spotify$apiGet$1
            r0.<init>(r5, r7)
        L19:
            r7 = r0
            java.lang.Object r0 = r7.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r7.label
            r3 = 1
            switch(r2) {
                case 0: goto L33;
                case 1: goto L2e;
                default: goto L26;
            }
        L26:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L2e:
            kotlin.ResultKt.throwOnFailure(r0)
            r6 = r0
            goto L40
        L33:
            kotlin.ResultKt.throwOnFailure(r0)
            r2 = r5
            r7.label = r3
            java.lang.Object r6 = r2.apiGetStatus(r6, r7)
            if (r6 != r1) goto L40
            return r1
        L40:
            kotlin.Pair r6 = (kotlin.Pair) r6
            java.lang.Object r1 = r6.component1()
            java.lang.Number r1 = (java.lang.Number) r1
            int r1 = r1.intValue()
            java.lang.Object r6 = r6.component2()
            org.json.JSONObject r6 = (org.json.JSONObject) r6
            r2 = 200(0xc8, float:2.8E-43)
            r4 = 0
            if (r2 > r1) goto L5c
            r2 = 300(0x12c, float:4.2E-43)
            if (r1 >= r2) goto L5c
            goto L5d
        L5c:
            r3 = r4
        L5d:
            if (r3 == 0) goto L60
            goto L61
        L60:
            r6 = 0
        L61:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coldfriesinoctober.walrus.music.Spotify.apiGet(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:11:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object apiGetStatus(java.lang.String r7, kotlin.coroutines.Continuation<? super kotlin.Pair<java.lang.Integer, ? extends org.json.JSONObject>> r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof com.coldfriesinoctober.walrus.music.Spotify$apiGetStatus$1
            if (r0 == 0) goto L14
            r0 = r8
            com.coldfriesinoctober.walrus.music.Spotify$apiGetStatus$1 r0 = (com.coldfriesinoctober.walrus.music.Spotify$apiGetStatus$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L19
        L14:
            com.coldfriesinoctober.walrus.music.Spotify$apiGetStatus$1 r0 = new com.coldfriesinoctober.walrus.music.Spotify$apiGetStatus$1
            r0.<init>(r6, r8)
        L19:
            r8 = r0
            java.lang.Object r0 = r8.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r8.label
            switch(r2) {
                case 0: goto L3b;
                case 1: goto L32;
                case 2: goto L2d;
                default: goto L25;
            }
        L25:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L2d:
            kotlin.ResultKt.throwOnFailure(r0)
            r7 = r0
            goto L74
        L32:
            java.lang.Object r7 = r8.L$0
            java.lang.String r7 = (java.lang.String) r7
            kotlin.ResultKt.throwOnFailure(r0)
            r2 = r0
            goto L4b
        L3b:
            kotlin.ResultKt.throwOnFailure(r0)
            r2 = r6
            r8.L$0 = r7
            r3 = 1
            r8.label = r3
            java.lang.Object r2 = r2.accessToken(r8)
            if (r2 != r1) goto L4b
            return r1
        L4b:
            java.lang.String r2 = (java.lang.String) r2
            r3 = 0
            if (r2 != 0) goto L5b
            r7 = 401(0x191, float:5.62E-43)
            java.lang.Integer r7 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r7)
            kotlin.Pair r7 = kotlin.TuplesKt.to(r7, r3)
            return r7
        L5b:
            kotlinx.coroutines.CoroutineDispatcher r4 = kotlinx.coroutines.Dispatchers.getIO()
            kotlin.coroutines.CoroutineContext r4 = (kotlin.coroutines.CoroutineContext) r4
            com.coldfriesinoctober.walrus.music.Spotify$apiGetStatus$2 r5 = new com.coldfriesinoctober.walrus.music.Spotify$apiGetStatus$2
            r5.<init>(r7, r2, r3)
            kotlin.jvm.functions.Function2 r5 = (kotlin.jvm.functions.Function2) r5
            r8.L$0 = r3
            r3 = 2
            r8.label = r3
            java.lang.Object r7 = kotlinx.coroutines.BuildersKt.withContext(r4, r5, r8)
            if (r7 != r1) goto L74
            return r1
        L74:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coldfriesinoctober.walrus.music.Spotify.apiGetStatus(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:11:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object apiWrite(java.lang.String r8, java.lang.String r9, kotlin.coroutines.Continuation<? super kotlin.Pair<java.lang.Integer, java.lang.String>> r10) {
        /*
            r7 = this;
            boolean r0 = r10 instanceof com.coldfriesinoctober.walrus.music.Spotify$apiWrite$1
            if (r0 == 0) goto L14
            r0 = r10
            com.coldfriesinoctober.walrus.music.Spotify$apiWrite$1 r0 = (com.coldfriesinoctober.walrus.music.Spotify$apiWrite$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r10 = r0.label
            int r10 = r10 - r2
            r0.label = r10
            goto L19
        L14:
            com.coldfriesinoctober.walrus.music.Spotify$apiWrite$1 r0 = new com.coldfriesinoctober.walrus.music.Spotify$apiWrite$1
            r0.<init>(r7, r10)
        L19:
            r10 = r0
            java.lang.Object r0 = r10.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r10.label
            switch(r2) {
                case 0: goto L3f;
                case 1: goto L32;
                case 2: goto L2d;
                default: goto L25;
            }
        L25:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L2d:
            kotlin.ResultKt.throwOnFailure(r0)
            r8 = r0
            goto L81
        L32:
            java.lang.Object r8 = r10.L$1
            java.lang.String r8 = (java.lang.String) r8
            java.lang.Object r9 = r10.L$0
            java.lang.String r9 = (java.lang.String) r9
            kotlin.ResultKt.throwOnFailure(r0)
            r2 = r0
            goto L54
        L3f:
            kotlin.ResultKt.throwOnFailure(r0)
            r2 = r7
            r10.L$0 = r8
            r10.L$1 = r9
            r3 = 1
            r10.label = r3
            java.lang.Object r2 = r2.accessToken(r10)
            if (r2 != r1) goto L51
            return r1
        L51:
            r6 = r9
            r9 = r8
            r8 = r6
        L54:
            java.lang.String r2 = (java.lang.String) r2
            if (r2 != 0) goto L65
            r8 = 401(0x191, float:5.62E-43)
            java.lang.Integer r8 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r8)
            java.lang.String r9 = ""
            kotlin.Pair r8 = kotlin.TuplesKt.to(r8, r9)
            return r8
        L65:
            kotlinx.coroutines.CoroutineDispatcher r3 = kotlinx.coroutines.Dispatchers.getIO()
            kotlin.coroutines.CoroutineContext r3 = (kotlin.coroutines.CoroutineContext) r3
            com.coldfriesinoctober.walrus.music.Spotify$apiWrite$2 r4 = new com.coldfriesinoctober.walrus.music.Spotify$apiWrite$2
            r5 = 0
            r4.<init>(r8, r2, r9, r5)
            kotlin.jvm.functions.Function2 r4 = (kotlin.jvm.functions.Function2) r4
            r10.L$0 = r5
            r10.L$1 = r5
            r5 = 2
            r10.label = r5
            java.lang.Object r8 = kotlinx.coroutines.BuildersKt.withContext(r3, r4, r10)
            if (r8 != r1) goto L81
            return r1
        L81:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coldfriesinoctober.walrus.music.Spotify.apiWrite(java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object awaitBody(final Call call, Continuation<? super Pair<Integer, String>> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        final CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
        cancellableContinuationImpl2.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: com.coldfriesinoctober.walrus.music.Spotify$awaitBody$2$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                Call.this.cancel();
            }
        });
        call.enqueue(new Callback() { // from class: com.coldfriesinoctober.walrus.music.Spotify$awaitBody$2$2
            @Override // okhttp3.Callback
            public void onFailure(Call call2, IOException e) {
                Intrinsics.checkNotNullParameter(call2, "call");
                Intrinsics.checkNotNullParameter(e, "e");
                CancellableContinuation<Pair<Integer, String>> cancellableContinuation = cancellableContinuationImpl2;
                String message = e.getMessage();
                if (message == null) {
                    message = "io error";
                }
                Pair pair = TuplesKt.to(0, message);
                Result.Companion companion = Result.INSTANCE;
                cancellableContinuation.resumeWith(Result.m6535constructorimpl(pair));
            }

            @Override // okhttp3.Callback
            public void onResponse(Call call2, Response response) {
                Object m6535constructorimpl;
                Intrinsics.checkNotNullParameter(call2, "call");
                Intrinsics.checkNotNullParameter(response, "response");
                try {
                    Result.Companion companion = Result.INSTANCE;
                    Spotify$awaitBody$2$2 spotify$awaitBody$2$2 = this;
                    Response response2 = response;
                    try {
                        Response response3 = response2;
                        Integer valueOf = Integer.valueOf(response3.code());
                        ResponseBody body = response3.body();
                        String string = body != null ? body.string() : null;
                        if (string == null) {
                            string = "";
                        }
                        Pair pair = TuplesKt.to(valueOf, string);
                        CloseableKt.closeFinally(response2, null);
                        m6535constructorimpl = Result.m6535constructorimpl(pair);
                    } finally {
                    }
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.INSTANCE;
                    m6535constructorimpl = Result.m6535constructorimpl(ResultKt.createFailure(th));
                }
                CancellableContinuation<Pair<Integer, String>> cancellableContinuation = cancellableContinuationImpl2;
                Object obj = TuplesKt.to(0, "");
                if (!Result.m6541isFailureimpl(m6535constructorimpl)) {
                    obj = m6535constructorimpl;
                }
                Result.Companion companion3 = Result.INSTANCE;
                cancellableContinuation.resumeWith(Result.m6535constructorimpl(obj));
            }
        });
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    private final boolean isDevModeBlock(int status, String body) {
        return status == 403 && (StringsKt.contains((CharSequence) body, (CharSequence) "not registered", true) || StringsKt.contains((CharSequence) body, (CharSequence) "developer dashboard", true));
    }

    private final String norm(String s) {
        String lowerCase = s.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        return StringsKt.trim((CharSequence) new Regex("\\s+").replace(new Regex("[^\\p{L}\\p{N} ]").replace(new Regex("(?i)\\b(feat\\.|ft\\.|with)\\b.*").replace(new Regex("\\(.*?\\)|\\[.*?\\]").replace(lowerCase, ""), ""), Stream.ID_UNKNOWN), Stream.ID_UNKNOWN)).toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object postForm(FormBody formBody, Continuation<? super Pair<Integer, ? extends JSONObject>> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new Spotify$postForm$2(formBody, null), continuation);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object resolveVideoId$default(Spotify spotify, SpTrack spTrack, Map map, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            map = spotify.loadMap();
        }
        return spotify.resolveVideoId(spTrack, map, continuation);
    }

    private final void saveMap(Map<String, String> map) {
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            jSONObject.put(entry.getKey(), entry.getValue());
        }
        Prefs prefs = Prefs.INSTANCE;
        Preferences.Key<String> spotify_yt_map = Prefs.INSTANCE.getSPOTIFY_YT_MAP();
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "toString(...)");
        prefs.setBlocking(spotify_yt_map, jSONObject2);
    }

    public static /* synthetic */ Object searchTrack$default(Spotify spotify, String str, String str2, long j, Continuation continuation, int i, Object obj) {
        if ((i & 4) != 0) {
            j = 0;
        }
        return spotify.searchTrack(str, str2, j, continuation);
    }

    private static final boolean searchTrack$plausible(String str, String str2, SpTrack spTrack) {
        boolean z;
        String norm = INSTANCE.norm(spTrack.getTitle());
        if (!(Intrinsics.areEqual(norm, str) || StringsKt.contains$default((CharSequence) norm, (CharSequence) str, false, 2, (Object) null) || StringsKt.contains$default((CharSequence) str, (CharSequence) norm, false, 2, (Object) null))) {
            return false;
        }
        if (StringsKt.isBlank(str2)) {
            return true;
        }
        String norm2 = INSTANCE.norm(spTrack.getArtist());
        List split$default = StringsKt.split$default((CharSequence) str2, new String[]{Stream.ID_UNKNOWN}, false, 0, 6, (Object) null);
        ArrayList arrayList = new ArrayList();
        for (Object obj : split$default) {
            if (((String) obj).length() > 2) {
                arrayList.add(obj);
            }
        }
        Set set = CollectionsKt.toSet(arrayList);
        if (!set.isEmpty()) {
            Set set2 = set;
            if (!(set2 instanceof Collection) || !set2.isEmpty()) {
                Iterator it = set2.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z = false;
                        break;
                    }
                    if (StringsKt.contains$default((CharSequence) norm2, (CharSequence) it.next(), false, 2, (Object) null)) {
                        z = true;
                        break;
                    }
                }
            } else {
                z = false;
            }
            if (!z) {
                return false;
            }
        }
        return true;
    }

    private final void storeTokens(JSONObject obj) {
        String optString = obj.optString("access_token");
        Intrinsics.checkNotNull(optString);
        if (StringsKt.isBlank(optString)) {
            return;
        }
        long optLong = obj.optLong("expires_in", 3600L);
        Prefs.INSTANCE.setBlocking(Prefs.INSTANCE.getSPOTIFY_ACCESS(), optString);
        Prefs.INSTANCE.setBlocking(Prefs.INSTANCE.getSPOTIFY_EXP(), String.valueOf((System.currentTimeMillis() / 1000) + optLong));
        String optString2 = obj.optString("refresh_token");
        Intrinsics.checkNotNull(optString2);
        if (!StringsKt.isBlank(optString2)) {
            Prefs.INSTANCE.setBlocking(Prefs.INSTANCE.getSPOTIFY_REFRESH(), optString2);
        }
        String optString3 = obj.optString("scope");
        Intrinsics.checkNotNull(optString3);
        if (!StringsKt.isBlank(optString3)) {
            Prefs.INSTANCE.setBlocking(Prefs.INSTANCE.getSPOTIFY_SCOPE(), optString3);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0028  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object accessToken(kotlin.coroutines.Continuation<? super java.lang.String> r15) {
        /*
            Method dump skipped, instructions count: 292
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coldfriesinoctober.walrus.music.Spotify.accessToken(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final String authUrl(String challenge) {
        Intrinsics.checkNotNullParameter(challenge, "challenge");
        return "https://accounts.spotify.com/authorize?response_type=code&client_id=2723dc6ecbac48e28949994c3b29d8b7&redirect_uri=" + URLEncoder.encode(REDIRECT_URI, CharsetNames.UTF_8) + "&scope=" + URLEncoder.encode(SCOPES, CharsetNames.UTF_8) + "&code_challenge_method=S256&code_challenge=" + challenge + "&show_dialog=true";
    }

    public final String challengeFor(String verifier) {
        Intrinsics.checkNotNullParameter(verifier, "verifier");
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        byte[] bytes = verifier.getBytes(Charsets.US_ASCII);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        String encodeToString = Base64.encodeToString(messageDigest.digest(bytes), 11);
        Intrinsics.checkNotNullExpressionValue(encodeToString, "encodeToString(...)");
        return encodeToString;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final List<SpTrack> decodeLikes(String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        List<String> lines = StringsKt.lines(text);
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = lines.iterator();
        while (it.hasNext()) {
            List<String> list = lines;
            List split$default = StringsKt.split$default((CharSequence) it.next(), new String[]{"\t"}, false, 0, 6, (Object) null);
            if (split$default.size() >= 5 && !StringsKt.isBlank((CharSequence) split$default.get(0))) {
                String str = (String) split$default.get(0);
                String str2 = (String) split$default.get(1);
                String str3 = (String) split$default.get(2);
                Long longOrNull = StringsKt.toLongOrNull((String) split$default.get(3));
                long longValue = longOrNull != null ? longOrNull.longValue() : 0L;
                Object obj = split$default.get(4);
                r16 = new SpTrack(str, str2, str3, longValue, (String) (StringsKt.isBlank((String) obj) ^ true ? obj : null));
            }
            if (r16 != null) {
                arrayList.add(r16);
            }
            lines = list;
        }
        return arrayList;
    }

    public final void disconnect() {
        Prefs.INSTANCE.setBlocking(Prefs.INSTANCE.getSPOTIFY_REFRESH(), "");
        Prefs.INSTANCE.setBlocking(Prefs.INSTANCE.getSPOTIFY_ACCESS(), "");
        Prefs.INSTANCE.setBlocking(Prefs.INSTANCE.getSPOTIFY_EXP(), "");
        Prefs.INSTANCE.setBlocking(Prefs.INSTANCE.getSPOTIFY_ACCOUNT(), "");
        Prefs.INSTANCE.setBlocking(Prefs.INSTANCE.getSPOTIFY_LIKES(), "");
        Prefs.INSTANCE.setBlocking(Prefs.INSTANCE.getSPOTIFY_SCOPE(), "");
        Prefs.INSTANCE.setBlocking(Prefs.INSTANCE.getSPOTIFY_VERIFIER(), "");
    }

    public final String encodeLikes(List<SpTrack> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        return CollectionsKt.joinToString$default(list, IOUtils.LINE_SEPARATOR_UNIX, null, null, 0, null, new Function1<SpTrack, CharSequence>() { // from class: com.coldfriesinoctober.walrus.music.Spotify$encodeLikes$1
            @Override // kotlin.jvm.functions.Function1
            public final CharSequence invoke(Spotify.SpTrack t) {
                Intrinsics.checkNotNullParameter(t, "t");
                String[] strArr = new String[5];
                strArr[0] = t.getId();
                strArr[1] = t.getTitle();
                strArr[2] = t.getArtist();
                strArr[3] = String.valueOf(t.getDurationMs());
                String artUrl = t.getArtUrl();
                if (artUrl == null) {
                    artUrl = "";
                }
                strArr[4] = artUrl;
                return CollectionsKt.joinToString$default(CollectionsKt.listOf((Object[]) strArr), "\t", null, null, 0, null, new Function1<String, CharSequence>() { // from class: com.coldfriesinoctober.walrus.music.Spotify$encodeLikes$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final CharSequence invoke(String it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        return StringsKt.replace$default(StringsKt.replace$default(it, "\t", Stream.ID_UNKNOWN, false, 4, (Object) null), IOUtils.LINE_SEPARATOR_UNIX, Stream.ID_UNKNOWN, false, 4, (Object) null);
                    }
                }, 30, null);
            }
        }, 30, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:11:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object exchangeCode(java.lang.String r8, java.lang.String r9, kotlin.coroutines.Continuation<? super java.lang.Boolean> r10) {
        /*
            r7 = this;
            boolean r0 = r10 instanceof com.coldfriesinoctober.walrus.music.Spotify$exchangeCode$1
            if (r0 == 0) goto L14
            r0 = r10
            com.coldfriesinoctober.walrus.music.Spotify$exchangeCode$1 r0 = (com.coldfriesinoctober.walrus.music.Spotify$exchangeCode$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r10 = r0.label
            int r10 = r10 - r2
            r0.label = r10
            goto L19
        L14:
            com.coldfriesinoctober.walrus.music.Spotify$exchangeCode$1 r0 = new com.coldfriesinoctober.walrus.music.Spotify$exchangeCode$1
            r0.<init>(r7, r10)
        L19:
            r10 = r0
            java.lang.Object r0 = r10.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r10.label
            r3 = 1
            switch(r2) {
                case 0: goto L38;
                case 1: goto L2e;
                default: goto L26;
            }
        L26:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L2e:
            java.lang.Object r8 = r10.L$0
            com.coldfriesinoctober.walrus.music.Spotify r8 = (com.coldfriesinoctober.walrus.music.Spotify) r8
            kotlin.ResultKt.throwOnFailure(r0)
            r2 = r8
            r8 = r0
            goto L76
        L38:
            kotlin.ResultKt.throwOnFailure(r0)
            r2 = r7
            okhttp3.FormBody$Builder r4 = new okhttp3.FormBody$Builder
            r5 = 0
            r4.<init>(r5, r3, r5)
            java.lang.String r5 = "grant_type"
            java.lang.String r6 = "authorization_code"
            okhttp3.FormBody$Builder r4 = r4.add(r5, r6)
            java.lang.String r5 = "code"
            okhttp3.FormBody$Builder r8 = r4.add(r5, r8)
            java.lang.String r4 = "redirect_uri"
            java.lang.String r5 = "walrus://callback"
            okhttp3.FormBody$Builder r8 = r8.add(r4, r5)
            java.lang.String r4 = "client_id"
            java.lang.String r5 = "2723dc6ecbac48e28949994c3b29d8b7"
            okhttp3.FormBody$Builder r8 = r8.add(r4, r5)
            java.lang.String r4 = "code_verifier"
            okhttp3.FormBody$Builder r8 = r8.add(r4, r9)
            okhttp3.FormBody r8 = r8.build()
            r10.L$0 = r2
            r10.label = r3
            java.lang.Object r8 = r2.postForm(r8, r10)
            if (r8 != r1) goto L76
            return r1
        L76:
            kotlin.Pair r8 = (kotlin.Pair) r8
            java.lang.Object r8 = r8.component2()
            org.json.JSONObject r8 = (org.json.JSONObject) r8
            if (r8 == 0) goto L9c
            java.lang.String r9 = "access_token"
            java.lang.String r9 = r8.optString(r9)
            java.lang.String r1 = "optString(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r1)
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            boolean r9 = kotlin.text.StringsKt.isBlank(r9)
            if (r9 == 0) goto L94
            goto L9c
        L94:
            r2.storeTokens(r8)
            java.lang.Boolean r9 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r3)
            return r9
        L9c:
            r8 = 0
            java.lang.Boolean r8 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r8)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coldfriesinoctober.walrus.music.Spotify.exchangeCode(java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object fetchAccountName(kotlin.coroutines.Continuation<? super java.lang.String> r8) {
        /*
            r7 = this;
            boolean r0 = r8 instanceof com.coldfriesinoctober.walrus.music.Spotify$fetchAccountName$1
            if (r0 == 0) goto L14
            r0 = r8
            com.coldfriesinoctober.walrus.music.Spotify$fetchAccountName$1 r0 = (com.coldfriesinoctober.walrus.music.Spotify$fetchAccountName$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L19
        L14:
            com.coldfriesinoctober.walrus.music.Spotify$fetchAccountName$1 r0 = new com.coldfriesinoctober.walrus.music.Spotify$fetchAccountName$1
            r0.<init>(r7, r8)
        L19:
            r8 = r0
            java.lang.Object r0 = r8.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r8.label
            r3 = 1
            switch(r2) {
                case 0: goto L33;
                case 1: goto L2e;
                default: goto L26;
            }
        L26:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L2e:
            kotlin.ResultKt.throwOnFailure(r0)
            r2 = r0
            goto L42
        L33:
            kotlin.ResultKt.throwOnFailure(r0)
            r2 = r7
            r8.label = r3
            java.lang.String r4 = "/me"
            java.lang.Object r2 = r2.apiGet(r4, r8)
            if (r2 != r1) goto L42
            return r1
        L42:
            org.json.JSONObject r2 = (org.json.JSONObject) r2
            r1 = 0
            if (r2 == 0) goto L5f
            java.lang.String r4 = "display_name"
            java.lang.String r2 = r2.optString(r4)
            if (r2 == 0) goto L5f
            r4 = r2
            r5 = 0
            r6 = r4
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            boolean r6 = kotlin.text.StringsKt.isBlank(r6)
            if (r6 != 0) goto L5b
            goto L5c
        L5b:
            r3 = 0
        L5c:
            if (r3 == 0) goto L5f
            r1 = r2
        L5f:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coldfriesinoctober.walrus.music.Spotify.fetchAccountName(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:7:0x002a. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:103:0x007a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:104:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002d  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:91:0x007b -> B:12:0x0084). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object fetchAllLiked(kotlin.coroutines.Continuation<? super java.util.List<com.coldfriesinoctober.walrus.music.Spotify.SpTrack>> r36) {
        /*
            Method dump skipped, instructions count: 580
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coldfriesinoctober.walrus.music.Spotify.fetchAllLiked(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final String getPendingVerifier() {
        return pendingVerifier;
    }

    public final boolean grantedCanWrite() {
        return StringsKt.split$default((CharSequence) Prefs.INSTANCE.get(Prefs.INSTANCE.getSPOTIFY_SCOPE(), ""), new String[]{Stream.ID_UNKNOWN}, false, 0, 6, (Object) null).contains("user-library-modify");
    }

    public final boolean isConnected() {
        return !StringsKt.isBlank((CharSequence) Prefs.INSTANCE.get(Prefs.INSTANCE.getSPOTIFY_REFRESH(), ""));
    }

    public final Map<String, String> loadMap() {
        Object m6535constructorimpl;
        String str = (String) Prefs.INSTANCE.get(Prefs.INSTANCE.getSPOTIFY_YT_MAP(), "");
        if (StringsKt.isBlank(str)) {
            return new LinkedHashMap();
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            Spotify spotify = this;
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> keys = jSONObject.keys();
            Intrinsics.checkNotNullExpressionValue(keys, "keys(...)");
            Sequence asSequence = SequencesKt.asSequence(keys);
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Object obj : asSequence) {
                linkedHashMap.put(obj, jSONObject.getString((String) obj));
            }
            m6535constructorimpl = Result.m6535constructorimpl(MapsKt.toMutableMap(linkedHashMap));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            m6535constructorimpl = Result.m6535constructorimpl(ResultKt.createFailure(th));
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        if (Result.m6541isFailureimpl(m6535constructorimpl)) {
            m6535constructorimpl = linkedHashMap2;
        }
        return (Map) m6535constructorimpl;
    }

    public final String newVerifier() {
        SecureRandom secureRandom = new SecureRandom();
        StringBuilder sb = new StringBuilder(64);
        for (int i = 0; i < 64; i++) {
            sb.append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-._~".charAt(secureRandom.nextInt("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-._~".length())));
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
        return sb2;
    }

    public final Pair<String, String> parseRedirect(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        if (!StringsKt.startsWith$default(url, REDIRECT_URI, false, 2, (Object) null)) {
            return TuplesKt.to(null, null);
        }
        String str = null;
        String str2 = null;
        for (String str3 : StringsKt.split$default((CharSequence) StringsKt.substringAfter(url, '?', ""), new char[]{Typography.amp}, false, 0, 6, (Object) null)) {
            String substringBefore$default = StringsKt.substringBefore$default(str3, '=', (String) null, 2, (Object) null);
            String decode = URLDecoder.decode(StringsKt.substringAfter(str3, '=', ""), CharsetNames.UTF_8);
            if (Intrinsics.areEqual(substringBefore$default, "code")) {
                str = decode;
            }
            if (Intrinsics.areEqual(substringBefore$default, "error")) {
                str2 = decode;
            }
        }
        return TuplesKt.to(str, str2);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(11:1|(2:3|(9:5|6|7|8|15|16|(1:18)|19|(1:21)(6:22|(2:24|(2:25|(4:27|(1:29)|(3:31|32|33)(1:35)|34)(5:36|37|(1:39)(2:55|(1:57)(2:58|(4:59|(1:61)(1:66)|62|(1:65)(1:64))))|40|(3:42|(1:44)(1:53)|(1:46)(1:52))(1:54))))(1:67)|47|(1:49)|50|51)))|83|6|7|8|15|16|(0)|19|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x0049, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x00b3, code lost:
    
        r8 = kotlin.Result.INSTANCE;
        r0 = kotlin.Result.m6535constructorimpl(kotlin.ResultKt.createFailure(r0));
        r4 = r4;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00d1 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x002d  */
    /* JADX WARN: Type inference failed for: r4v1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object resolveVideoId(com.coldfriesinoctober.walrus.music.Spotify.SpTrack r21, java.util.Map<java.lang.String, java.lang.String> r22, kotlin.coroutines.Continuation<? super java.lang.String> r23) {
        /*
            Method dump skipped, instructions count: 462
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coldfriesinoctober.walrus.music.Spotify.resolveVideoId(com.coldfriesinoctober.walrus.music.Spotify$SpTrack, java.util.Map, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object searchTrack(java.lang.String r38, java.lang.String r39, long r40, kotlin.coroutines.Continuation<? super com.coldfriesinoctober.walrus.music.Spotify.SearchOutcome> r42) {
        /*
            Method dump skipped, instructions count: 856
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coldfriesinoctober.walrus.music.Spotify.searchTrack(java.lang.String, java.lang.String, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Can't wrap try/catch for region: R(9:1|(2:3|(7:5|6|7|8|15|16|(3:18|(1:22)|(2:24|25)(2:26|(2:28|29)(2:30|(2:36|37)(2:34|35))))(2:38|39)))|62|6|7|8|15|16|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0041, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00d9, code lost:
    
        r7 = kotlin.Result.INSTANCE;
        r0 = kotlin.Result.m6535constructorimpl(kotlin.ResultKt.createFailure(r0));
        r4 = r4;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x002e  */
    /* JADX WARN: Type inference failed for: r4v1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object setLiked(java.lang.String r18, boolean r19, kotlin.coroutines.Continuation<? super com.coldfriesinoctober.walrus.music.Spotify.WriteResult> r20) {
        /*
            Method dump skipped, instructions count: 304
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coldfriesinoctober.walrus.music.Spotify.setLiked(java.lang.String, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void setPendingVerifier(String str) {
        pendingVerifier = str;
    }
}

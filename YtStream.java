package com.coldfriesinoctober.walrus.music;

import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.schabi.newpipe.extractor.stream.Stream;

/* compiled from: YtMusicApi.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\b¢\u0006\u0002\u0010\tJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÆ\u0003J\u0015\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\bHÆ\u0003J?\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\bHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u001d\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000e¨\u0006\u001d"}, d2 = {"Lcom/coldfriesinoctober/walrus/music/YtStream;", "", "url", "", "mimeType", "bitrate", "", "headers", "", "(Ljava/lang/String;Ljava/lang/String;ILjava/util/Map;)V", "getBitrate", "()I", "codecLabel", "getCodecLabel", "()Ljava/lang/String;", "getHeaders", "()Ljava/util/Map;", "getMimeType", "getUrl", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "app_debug"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class YtStream {
    public static final int $stable = 8;
    private final int bitrate;
    private final Map<String, String> headers;
    private final String mimeType;
    private final String url;

    public YtStream(String url, String str, int i, Map<String, String> headers) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(headers, "headers");
        this.url = url;
        this.mimeType = str;
        this.bitrate = i;
        this.headers = headers;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ YtStream copy$default(YtStream ytStream, String str, String str2, int i, Map map, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = ytStream.url;
        }
        if ((i2 & 2) != 0) {
            str2 = ytStream.mimeType;
        }
        if ((i2 & 4) != 0) {
            i = ytStream.bitrate;
        }
        if ((i2 & 8) != 0) {
            map = ytStream.headers;
        }
        return ytStream.copy(str, str2, i, map);
    }

    /* renamed from: component1, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    /* renamed from: component2, reason: from getter */
    public final String getMimeType() {
        return this.mimeType;
    }

    /* renamed from: component3, reason: from getter */
    public final int getBitrate() {
        return this.bitrate;
    }

    public final Map<String, String> component4() {
        return this.headers;
    }

    public final YtStream copy(String url, String mimeType, int bitrate, Map<String, String> headers) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(headers, "headers");
        return new YtStream(url, mimeType, bitrate, headers);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof YtStream)) {
            return false;
        }
        YtStream ytStream = (YtStream) other;
        return Intrinsics.areEqual(this.url, ytStream.url) && Intrinsics.areEqual(this.mimeType, ytStream.mimeType) && this.bitrate == ytStream.bitrate && Intrinsics.areEqual(this.headers, ytStream.headers);
    }

    public final int getBitrate() {
        return this.bitrate;
    }

    public final String getCodecLabel() {
        String str;
        if (this.mimeType == null) {
            str = "AUDIO";
        } else if (StringsKt.contains$default((CharSequence) this.mimeType, (CharSequence) "opus", false, 2, (Object) null)) {
            str = "OPUS";
        } else if (StringsKt.contains$default((CharSequence) this.mimeType, (CharSequence) "mp4", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) this.mimeType, (CharSequence) "m4a", false, 2, (Object) null)) {
            str = "AAC";
        } else if (StringsKt.contains$default((CharSequence) this.mimeType, (CharSequence) "webm", false, 2, (Object) null)) {
            str = "WEBM";
        } else if (StringsKt.contains$default((CharSequence) this.mimeType, (CharSequence) "mpeg", false, 2, (Object) null)) {
            str = "MP3";
        } else {
            str = StringsKt.substringAfter$default(this.mimeType, '/', (String) null, 2, (Object) null).toUpperCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(str, "toUpperCase(...)");
        }
        if (this.bitrate <= 0) {
            return str;
        }
        return str + Stream.ID_UNKNOWN + (this.bitrate / 1000) + "k";
    }

    public final Map<String, String> getHeaders() {
        return this.headers;
    }

    public final String getMimeType() {
        return this.mimeType;
    }

    public final String getUrl() {
        return this.url;
    }

    public int hashCode() {
        return (((((this.url.hashCode() * 31) + (this.mimeType == null ? 0 : this.mimeType.hashCode())) * 31) + Integer.hashCode(this.bitrate)) * 31) + this.headers.hashCode();
    }

    public String toString() {
        return "YtStream(url=" + this.url + ", mimeType=" + this.mimeType + ", bitrate=" + this.bitrate + ", headers=" + this.headers + ")";
    }
}

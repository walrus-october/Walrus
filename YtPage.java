package com.coldfriesinoctober.walrus.music;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: YtMusicApi.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J;\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/coldfriesinoctober/walrus/music/YtPage;", "", "title", "", "subtitle", "artworkUrl", "tracks", "", "Lcom/coldfriesinoctober/walrus/music/YtTrack;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getArtworkUrl", "()Ljava/lang/String;", "getSubtitle", "getTitle", "getTracks", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "app_debug"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class YtPage {
    public static final int $stable = 8;
    private final String artworkUrl;
    private final String subtitle;
    private final String title;
    private final List<YtTrack> tracks;

    public YtPage(String title, String str, String str2, List<YtTrack> tracks) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(tracks, "tracks");
        this.title = title;
        this.subtitle = str;
        this.artworkUrl = str2;
        this.tracks = tracks;
    }

    public /* synthetic */ YtPage(String str, String str2, String str3, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? CollectionsKt.emptyList() : list);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ YtPage copy$default(YtPage ytPage, String str, String str2, String str3, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = ytPage.title;
        }
        if ((i & 2) != 0) {
            str2 = ytPage.subtitle;
        }
        if ((i & 4) != 0) {
            str3 = ytPage.artworkUrl;
        }
        if ((i & 8) != 0) {
            list = ytPage.tracks;
        }
        return ytPage.copy(str, str2, str3, list);
    }

    /* renamed from: component1, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* renamed from: component2, reason: from getter */
    public final String getSubtitle() {
        return this.subtitle;
    }

    /* renamed from: component3, reason: from getter */
    public final String getArtworkUrl() {
        return this.artworkUrl;
    }

    public final List<YtTrack> component4() {
        return this.tracks;
    }

    public final YtPage copy(String title, String subtitle, String artworkUrl, List<YtTrack> tracks) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(tracks, "tracks");
        return new YtPage(title, subtitle, artworkUrl, tracks);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof YtPage)) {
            return false;
        }
        YtPage ytPage = (YtPage) other;
        return Intrinsics.areEqual(this.title, ytPage.title) && Intrinsics.areEqual(this.subtitle, ytPage.subtitle) && Intrinsics.areEqual(this.artworkUrl, ytPage.artworkUrl) && Intrinsics.areEqual(this.tracks, ytPage.tracks);
    }

    public final String getArtworkUrl() {
        return this.artworkUrl;
    }

    public final String getSubtitle() {
        return this.subtitle;
    }

    public final String getTitle() {
        return this.title;
    }

    public final List<YtTrack> getTracks() {
        return this.tracks;
    }

    public int hashCode() {
        return (((((this.title.hashCode() * 31) + (this.subtitle == null ? 0 : this.subtitle.hashCode())) * 31) + (this.artworkUrl != null ? this.artworkUrl.hashCode() : 0)) * 31) + this.tracks.hashCode();
    }

    public String toString() {
        return "YtPage(title=" + this.title + ", subtitle=" + this.subtitle + ", artworkUrl=" + this.artworkUrl + ", tracks=" + this.tracks + ")";
    }
}

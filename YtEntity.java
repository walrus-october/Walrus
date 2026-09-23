package com.coldfriesinoctober.walrus.music;

import androidx.autofill.HintConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: YtMusicApi.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003J?\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006\u001d"}, d2 = {"Lcom/coldfriesinoctober/walrus/music/YtEntity;", "", "kind", "Lcom/coldfriesinoctober/walrus/music/YtEntityKind;", HintConstants.AUTOFILL_HINT_NAME, "", "subtitle", "browseId", "artworkUrl", "(Lcom/coldfriesinoctober/walrus/music/YtEntityKind;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getArtworkUrl", "()Ljava/lang/String;", "getBrowseId", "getKind", "()Lcom/coldfriesinoctober/walrus/music/YtEntityKind;", "getName", "getSubtitle", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "app_debug"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class YtEntity {
    public static final int $stable = 0;
    private final String artworkUrl;
    private final String browseId;
    private final YtEntityKind kind;
    private final String name;
    private final String subtitle;

    public YtEntity(YtEntityKind kind, String name, String str, String browseId, String str2) {
        Intrinsics.checkNotNullParameter(kind, "kind");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(browseId, "browseId");
        this.kind = kind;
        this.name = name;
        this.subtitle = str;
        this.browseId = browseId;
        this.artworkUrl = str2;
    }

    public /* synthetic */ YtEntity(YtEntityKind ytEntityKind, String str, String str2, String str3, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(ytEntityKind, str, (i & 4) != 0 ? null : str2, str3, (i & 16) != 0 ? null : str4);
    }

    public static /* synthetic */ YtEntity copy$default(YtEntity ytEntity, YtEntityKind ytEntityKind, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            ytEntityKind = ytEntity.kind;
        }
        if ((i & 2) != 0) {
            str = ytEntity.name;
        }
        String str5 = str;
        if ((i & 4) != 0) {
            str2 = ytEntity.subtitle;
        }
        String str6 = str2;
        if ((i & 8) != 0) {
            str3 = ytEntity.browseId;
        }
        String str7 = str3;
        if ((i & 16) != 0) {
            str4 = ytEntity.artworkUrl;
        }
        return ytEntity.copy(ytEntityKind, str5, str6, str7, str4);
    }

    /* renamed from: component1, reason: from getter */
    public final YtEntityKind getKind() {
        return this.kind;
    }

    /* renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component3, reason: from getter */
    public final String getSubtitle() {
        return this.subtitle;
    }

    /* renamed from: component4, reason: from getter */
    public final String getBrowseId() {
        return this.browseId;
    }

    /* renamed from: component5, reason: from getter */
    public final String getArtworkUrl() {
        return this.artworkUrl;
    }

    public final YtEntity copy(YtEntityKind kind, String name, String subtitle, String browseId, String artworkUrl) {
        Intrinsics.checkNotNullParameter(kind, "kind");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(browseId, "browseId");
        return new YtEntity(kind, name, subtitle, browseId, artworkUrl);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof YtEntity)) {
            return false;
        }
        YtEntity ytEntity = (YtEntity) other;
        return this.kind == ytEntity.kind && Intrinsics.areEqual(this.name, ytEntity.name) && Intrinsics.areEqual(this.subtitle, ytEntity.subtitle) && Intrinsics.areEqual(this.browseId, ytEntity.browseId) && Intrinsics.areEqual(this.artworkUrl, ytEntity.artworkUrl);
    }

    public final String getArtworkUrl() {
        return this.artworkUrl;
    }

    public final String getBrowseId() {
        return this.browseId;
    }

    public final YtEntityKind getKind() {
        return this.kind;
    }

    public final String getName() {
        return this.name;
    }

    public final String getSubtitle() {
        return this.subtitle;
    }

    public int hashCode() {
        return (((((((this.kind.hashCode() * 31) + this.name.hashCode()) * 31) + (this.subtitle == null ? 0 : this.subtitle.hashCode())) * 31) + this.browseId.hashCode()) * 31) + (this.artworkUrl != null ? this.artworkUrl.hashCode() : 0);
    }

    public String toString() {
        return "YtEntity(kind=" + this.kind + ", name=" + this.name + ", subtitle=" + this.subtitle + ", browseId=" + this.browseId + ", artworkUrl=" + this.artworkUrl + ")";
    }
}

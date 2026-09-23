package com.coldfriesinoctober.walrus.music;

import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: YtMusicApi.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "Lcom/coldfriesinoctober/walrus/music/YtPlaylistSummary;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.coldfriesinoctober.walrus.music.YtMusicApi$searchPlaylists$2", f = "YtMusicApi.kt", i = {}, l = {462, 463}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
public final class YtMusicApi$searchPlaylists$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends YtPlaylistSummary>>, Object> {
    final /* synthetic */ int $limit;
    final /* synthetic */ String $query;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public YtMusicApi$searchPlaylists$2(String str, int i, Continuation<? super YtMusicApi$searchPlaylists$2> continuation) {
        super(2, continuation);
        this.$query = str;
        this.$limit = i;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new YtMusicApi$searchPlaylists$2(this.$query, this.$limit, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends YtPlaylistSummary>> continuation) {
        return invoke2(coroutineScope, (Continuation<? super List<YtPlaylistSummary>>) continuation);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super List<YtPlaylistSummary>> continuation) {
        return ((YtMusicApi$searchPlaylists$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0008. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:12:0x00cb A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x00cc  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r21) {
        /*
            r20 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            r1 = r20
            int r2 = r1.label
            switch(r2) {
                case 0: goto L26;
                case 1: goto L1d;
                case 2: goto L13;
                default: goto Lb;
            }
        Lb:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r2)
            throw r0
        L13:
            r0 = r20
            r2 = r21
            kotlin.ResultKt.throwOnFailure(r2)
            r3 = r2
            goto Lce
        L1d:
            r2 = r20
            r3 = r21
            kotlin.ResultKt.throwOnFailure(r3)
            r4 = r3
            goto L4b
        L26:
            kotlin.ResultKt.throwOnFailure(r21)
            r2 = r20
            r3 = r21
            java.lang.String r4 = r2.$query
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            boolean r4 = kotlin.text.StringsKt.isBlank(r4)
            if (r4 == 0) goto L3c
            java.util.List r0 = kotlin.collections.CollectionsKt.emptyList()
            return r0
        L3c:
            com.coldfriesinoctober.walrus.music.YtMusicApi r4 = com.coldfriesinoctober.walrus.music.YtMusicApi.INSTANCE
            r5 = r2
            kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5
            r6 = 1
            r2.label = r6
            java.lang.Object r4 = com.coldfriesinoctober.walrus.music.YtMusicApi.access$webConfig(r4, r5)
            if (r4 != r0) goto L4b
            return r0
        L4b:
            com.coldfriesinoctober.walrus.music.YtMusicApi$WebConfig r4 = (com.coldfriesinoctober.walrus.music.YtMusicApi.WebConfig) r4
            com.coldfriesinoctober.walrus.music.YtMusicApi r5 = com.coldfriesinoctober.walrus.music.YtMusicApi.INSTANCE
            java.lang.String r6 = r4.getApiKey()
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "https://music.youtube.com/youtubei/v1/search?key="
            java.lang.StringBuilder r7 = r7.append(r8)
            java.lang.StringBuilder r6 = r7.append(r6)
            java.lang.String r7 = "&prettyPrint=false"
            java.lang.StringBuilder r6 = r6.append(r7)
            java.lang.String r6 = r6.toString()
            java.lang.String r7 = r2.$query
            r8 = 0
            kotlinx.serialization.json.JsonObjectBuilder r9 = new kotlinx.serialization.json.JsonObjectBuilder
            r9.<init>()
            r10 = r9
            r11 = 0
            com.coldfriesinoctober.walrus.music.YtMusicApi r12 = com.coldfriesinoctober.walrus.music.YtMusicApi.INSTANCE
            java.lang.String r13 = r4.getClientVersion()
            java.lang.String r14 = r4.getVisitorData()
            java.lang.String r15 = "WEB_REMIX"
            kotlinx.serialization.json.JsonObject r12 = com.coldfriesinoctober.walrus.music.YtMusicApi.access$contextBlock(r12, r15, r13, r14)
            kotlinx.serialization.json.JsonElement r12 = (kotlinx.serialization.json.JsonElement) r12
            java.lang.String r13 = "context"
            r10.put(r13, r12)
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            java.lang.CharSequence r7 = kotlin.text.StringsKt.trim(r7)
            java.lang.String r7 = r7.toString()
            java.lang.String r12 = "query"
            kotlinx.serialization.json.JsonElementBuildersKt.put(r10, r12, r7)
            java.lang.String r7 = "params"
            java.lang.String r12 = "Eg-KAQwIABAAGAAgACgB"
            kotlinx.serialization.json.JsonElementBuildersKt.put(r10, r7, r12)
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            kotlinx.serialization.json.JsonObject r7 = r9.build()
            java.lang.String r9 = r4.getClientVersion()
            r17 = r2
            kotlin.coroutines.Continuation r17 = (kotlin.coroutines.Continuation) r17
            r4 = 2
            r2.label = r4
            java.lang.String r8 = "WEB_REMIX"
            java.lang.String r10 = "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:140.0) Gecko/20100101 Firefox/140.0"
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            r18 = 2016(0x7e0, float:2.825E-42)
            r19 = 0
            java.lang.Object r4 = com.coldfriesinoctober.walrus.music.YtMusicApi.post$default(r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19)
            if (r4 != r0) goto Lcc
            return r0
        Lcc:
            r0 = r2
            r2 = r4
        Lce:
            kotlinx.serialization.json.JsonObject r2 = (kotlinx.serialization.json.JsonObject) r2
            com.coldfriesinoctober.walrus.music.YtMusicApi r4 = com.coldfriesinoctober.walrus.music.YtMusicApi.INSTANCE
            r5 = r2
            kotlinx.serialization.json.JsonElement r5 = (kotlinx.serialization.json.JsonElement) r5
            java.util.List r4 = com.coldfriesinoctober.walrus.music.YtMusicApi.access$parsePlaylistRenderers(r4, r5)
            java.lang.Iterable r4 = (java.lang.Iterable) r4
            int r5 = r0.$limit
            java.util.List r4 = kotlin.collections.CollectionsKt.take(r4, r5)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coldfriesinoctober.walrus.music.YtMusicApi$searchPlaylists$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}

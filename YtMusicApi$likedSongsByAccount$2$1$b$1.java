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
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "Lcom/coldfriesinoctober/walrus/music/YtTrack;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.coldfriesinoctober.walrus.music.YtMusicApi$likedSongsByAccount$2$1$b$1", f = "YtMusicApi.kt", i = {}, l = {528}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
public final class YtMusicApi$likedSongsByAccount$2$1$b$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends YtTrack>>, Object> {
    final /* synthetic */ int $maxTracks;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public YtMusicApi$likedSongsByAccount$2$1$b$1(int i, Continuation<? super YtMusicApi$likedSongsByAccount$2$1$b$1> continuation) {
        super(2, continuation);
        this.$maxTracks = i;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        YtMusicApi$likedSongsByAccount$2$1$b$1 ytMusicApi$likedSongsByAccount$2$1$b$1 = new YtMusicApi$likedSongsByAccount$2$1$b$1(this.$maxTracks, continuation);
        ytMusicApi$likedSongsByAccount$2$1$b$1.L$0 = obj;
        return ytMusicApi$likedSongsByAccount$2$1$b$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends YtTrack>> continuation) {
        return invoke2(coroutineScope, (Continuation<? super List<YtTrack>>) continuation);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super List<YtTrack>> continuation) {
        return ((YtMusicApi$likedSongsByAccount$2$1$b$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0007. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:13:0x004a A[Catch: all -> 0x0055, TryCatch #0 {all -> 0x0055, blocks: (B:11:0x0046, B:13:0x004a, B:14:0x0050), top: B:10:0x0046 }] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x004f  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r11) {
        /*
            r10 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r10.label
            r2 = 0
            switch(r1) {
                case 0: goto L1d;
                case 1: goto L12;
                default: goto La;
            }
        La:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L12:
            r0 = r10
            r1 = 0
            kotlin.ResultKt.throwOnFailure(r11)     // Catch: java.lang.Throwable -> L1b
            r3 = r1
            r1 = r0
            r0 = r11
            goto L46
        L1b:
            r1 = move-exception
            goto L5f
        L1d:
            kotlin.ResultKt.throwOnFailure(r11)
            r1 = r10
            java.lang.Object r3 = r1.L$0
            kotlinx.coroutines.CoroutineScope r3 = (kotlinx.coroutines.CoroutineScope) r3
            com.coldfriesinoctober.walrus.music.YtMusicApi r4 = com.coldfriesinoctober.walrus.music.YtMusicApi.INSTANCE
            boolean r4 = r4.isLoggedIn2()
            if (r4 == 0) goto L81
            int r4 = r1.$maxTracks
            kotlin.Result$Companion r3 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L5b
            r3 = 0
            com.coldfriesinoctober.walrus.music.YtMusicApi r5 = com.coldfriesinoctober.walrus.music.YtMusicApi.INSTANCE     // Catch: java.lang.Throwable -> L5b
            java.lang.String r6 = "VLLM"
            java.util.Map r7 = com.coldfriesinoctober.walrus.music.YtMusicApi.access$getSessionCookies2$p()     // Catch: java.lang.Throwable -> L5b
            r8 = 1
            r1.label = r8     // Catch: java.lang.Throwable -> L5b
            java.lang.Object r4 = r5.trackListPage(r6, r4, r7, r1)     // Catch: java.lang.Throwable -> L5b
            if (r4 != r0) goto L44
            return r0
        L44:
            r0 = r11
            r11 = r4
        L46:
            com.coldfriesinoctober.walrus.music.YtPage r11 = (com.coldfriesinoctober.walrus.music.YtPage) r11     // Catch: java.lang.Throwable -> L55
            if (r11 == 0) goto L4f
            java.util.List r11 = r11.getTracks()     // Catch: java.lang.Throwable -> L55
            goto L50
        L4f:
            r11 = r2
        L50:
            java.lang.Object r11 = kotlin.Result.m6535constructorimpl(r11)     // Catch: java.lang.Throwable -> L55
            goto L6d
        L55:
            r11 = move-exception
            r9 = r1
            r1 = r11
            r11 = r0
            r0 = r9
            goto L5f
        L5b:
            r0 = move-exception
            r9 = r1
            r1 = r0
            r0 = r9
        L5f:
            kotlin.Result$Companion r3 = kotlin.Result.INSTANCE
            java.lang.Object r1 = kotlin.ResultKt.createFailure(r1)
            java.lang.Object r1 = kotlin.Result.m6535constructorimpl(r1)
            r9 = r0
            r0 = r11
            r11 = r1
            r1 = r9
        L6d:
            boolean r3 = kotlin.Result.m6541isFailureimpl(r11)
            if (r3 == 0) goto L74
            goto L75
        L74:
            r2 = r11
        L75:
            java.util.List r2 = (java.util.List) r2
            if (r2 != 0) goto L7f
            java.util.List r2 = kotlin.collections.CollectionsKt.emptyList()
            r11 = r0
            goto L85
        L7f:
            r11 = r0
            goto L85
        L81:
            java.util.List r2 = kotlin.collections.CollectionsKt.emptyList()
        L85:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coldfriesinoctober.walrus.music.YtMusicApi$likedSongsByAccount$2$1$b$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}

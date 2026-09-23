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
@DebugMetadata(c = "com.coldfriesinoctober.walrus.music.YtMusicApi$likedSongsByAccount$2$1$a$1", f = "YtMusicApi.kt", i = {}, l = {523}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
public final class YtMusicApi$likedSongsByAccount$2$1$a$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends YtTrack>>, Object> {
    final /* synthetic */ int $maxTracks;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public YtMusicApi$likedSongsByAccount$2$1$a$1(int i, Continuation<? super YtMusicApi$likedSongsByAccount$2$1$a$1> continuation) {
        super(2, continuation);
        this.$maxTracks = i;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        YtMusicApi$likedSongsByAccount$2$1$a$1 ytMusicApi$likedSongsByAccount$2$1$a$1 = new YtMusicApi$likedSongsByAccount$2$1$a$1(this.$maxTracks, continuation);
        ytMusicApi$likedSongsByAccount$2$1$a$1.L$0 = obj;
        return ytMusicApi$likedSongsByAccount$2$1$a$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends YtTrack>> continuation) {
        return invoke2(coroutineScope, (Continuation<? super List<YtTrack>>) continuation);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super List<YtTrack>> continuation) {
        return ((YtMusicApi$likedSongsByAccount$2$1$a$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0007. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0044 A[Catch: all -> 0x004f, TryCatch #2 {all -> 0x004f, blocks: (B:11:0x0040, B:13:0x0044, B:14:0x004a), top: B:10:0x0040 }] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0049  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r9) {
        /*
            r8 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r8.label
            r2 = 0
            switch(r1) {
                case 0: goto L1d;
                case 1: goto L12;
                default: goto La;
            }
        La:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L12:
            r0 = r8
            r1 = 0
            kotlin.ResultKt.throwOnFailure(r9)     // Catch: java.lang.Throwable -> L1b
            r3 = r1
            r1 = r0
            r0 = r9
            goto L40
        L1b:
            r1 = move-exception
            goto L59
        L1d:
            kotlin.ResultKt.throwOnFailure(r9)
            r1 = r8
            java.lang.Object r3 = r1.L$0
            kotlinx.coroutines.CoroutineScope r3 = (kotlinx.coroutines.CoroutineScope) r3
            com.coldfriesinoctober.walrus.music.YtMusicApi r4 = com.coldfriesinoctober.walrus.music.YtMusicApi.INSTANCE
            boolean r4 = r4.isLoggedIn()
            if (r4 == 0) goto L79
            int r4 = r1.$maxTracks
            kotlin.Result$Companion r3 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L55
            r3 = 0
            com.coldfriesinoctober.walrus.music.YtMusicApi r5 = com.coldfriesinoctober.walrus.music.YtMusicApi.INSTANCE     // Catch: java.lang.Throwable -> L55
            r6 = 1
            r1.label = r6     // Catch: java.lang.Throwable -> L55
            java.lang.Object r4 = r5.likedSongs(r4, r1)     // Catch: java.lang.Throwable -> L55
            if (r4 != r0) goto L3e
            return r0
        L3e:
            r0 = r9
            r9 = r4
        L40:
            com.coldfriesinoctober.walrus.music.YtPage r9 = (com.coldfriesinoctober.walrus.music.YtPage) r9     // Catch: java.lang.Throwable -> L4f
            if (r9 == 0) goto L49
            java.util.List r9 = r9.getTracks()     // Catch: java.lang.Throwable -> L4f
            goto L4a
        L49:
            r9 = r2
        L4a:
            java.lang.Object r9 = kotlin.Result.m6535constructorimpl(r9)     // Catch: java.lang.Throwable -> L4f
            goto L67
        L4f:
            r9 = move-exception
            r7 = r1
            r1 = r9
            r9 = r0
            r0 = r7
            goto L59
        L55:
            r0 = move-exception
            r7 = r1
            r1 = r0
            r0 = r7
        L59:
            kotlin.Result$Companion r3 = kotlin.Result.INSTANCE
            java.lang.Object r1 = kotlin.ResultKt.createFailure(r1)
            java.lang.Object r1 = kotlin.Result.m6535constructorimpl(r1)
            r7 = r0
            r0 = r9
            r9 = r1
            r1 = r7
        L67:
            boolean r3 = kotlin.Result.m6541isFailureimpl(r9)
            if (r3 == 0) goto L6e
            goto L6f
        L6e:
            r2 = r9
        L6f:
            java.util.List r2 = (java.util.List) r2
            if (r2 != 0) goto L77
            java.util.List r2 = kotlin.collections.CollectionsKt.emptyList()
        L77:
            r9 = r0
            goto L7d
        L79:
            java.util.List r2 = kotlin.collections.CollectionsKt.emptyList()
        L7d:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coldfriesinoctober.walrus.music.YtMusicApi$likedSongsByAccount$2$1$a$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}

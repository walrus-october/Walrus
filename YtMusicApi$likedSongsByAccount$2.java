package com.coldfriesinoctober.walrus.music;

import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: YtMusicApi.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001*\u00020\u0004H\u008a@"}, d2 = {"<anonymous>", "Lkotlin/Pair;", "", "Lcom/coldfriesinoctober/walrus/music/YtTrack;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.coldfriesinoctober.walrus.music.YtMusicApi$likedSongsByAccount$2", f = "YtMusicApi.kt", i = {}, l = {521}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
public final class YtMusicApi$likedSongsByAccount$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Pair<? extends List<? extends YtTrack>, ? extends List<? extends YtTrack>>>, Object> {
    final /* synthetic */ int $maxTracks;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: YtMusicApi.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001*\u00020\u0004H\u008a@"}, d2 = {"<anonymous>", "Lkotlin/Pair;", "", "Lcom/coldfriesinoctober/walrus/music/YtTrack;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.coldfriesinoctober.walrus.music.YtMusicApi$likedSongsByAccount$2$1", f = "YtMusicApi.kt", i = {0}, l = {532, 532}, m = "invokeSuspend", n = {"b"}, s = {"L$0"})
    /* renamed from: com.coldfriesinoctober.walrus.music.YtMusicApi$likedSongsByAccount$2$1, reason: invalid class name */
    /* loaded from: classes5.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Pair<? extends List<? extends YtTrack>, ? extends List<? extends YtTrack>>>, Object> {
        final /* synthetic */ int $maxTracks;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(int i, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$maxTracks = i;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$maxTracks, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super Pair<? extends List<? extends YtTrack>, ? extends List<? extends YtTrack>>> continuation) {
            return invoke2(coroutineScope, (Continuation<? super Pair<? extends List<YtTrack>, ? extends List<YtTrack>>>) continuation);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super Pair<? extends List<YtTrack>, ? extends List<YtTrack>>> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0006. Please report as an issue. */
        /* JADX WARN: Removed duplicated region for block: B:12:0x006e A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:13:0x006f  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r12) {
            /*
                r11 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r11.label
                switch(r1) {
                    case 0: goto L25;
                    case 1: goto L1b;
                    case 2: goto L11;
                    default: goto L9;
                }
            L9:
                java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r12.<init>(r0)
                throw r12
            L11:
                r0 = r11
                java.lang.Object r1 = r0.L$0
                kotlin.ResultKt.throwOnFailure(r12)
                r3 = r1
                r1 = r0
                r0 = r12
                goto L71
            L1b:
                r1 = r11
                java.lang.Object r2 = r1.L$0
                kotlinx.coroutines.Deferred r2 = (kotlinx.coroutines.Deferred) r2
                kotlin.ResultKt.throwOnFailure(r12)
                r3 = r12
                goto L60
            L25:
                kotlin.ResultKt.throwOnFailure(r12)
                r1 = r11
                java.lang.Object r2 = r1.L$0
                kotlinx.coroutines.CoroutineScope r2 = (kotlinx.coroutines.CoroutineScope) r2
                com.coldfriesinoctober.walrus.music.YtMusicApi$likedSongsByAccount$2$1$a$1 r3 = new com.coldfriesinoctober.walrus.music.YtMusicApi$likedSongsByAccount$2$1$a$1
                int r4 = r1.$maxTracks
                r9 = 0
                r3.<init>(r4, r9)
                r6 = r3
                kotlin.jvm.functions.Function2 r6 = (kotlin.jvm.functions.Function2) r6
                r7 = 3
                r8 = 0
                r4 = 0
                r5 = 0
                r3 = r2
                kotlinx.coroutines.Deferred r10 = kotlinx.coroutines.BuildersKt.async$default(r3, r4, r5, r6, r7, r8)
                com.coldfriesinoctober.walrus.music.YtMusicApi$likedSongsByAccount$2$1$b$1 r3 = new com.coldfriesinoctober.walrus.music.YtMusicApi$likedSongsByAccount$2$1$b$1
                int r4 = r1.$maxTracks
                r3.<init>(r4, r9)
                r6 = r3
                kotlin.jvm.functions.Function2 r6 = (kotlin.jvm.functions.Function2) r6
                r4 = 0
                r3 = r2
                kotlinx.coroutines.Deferred r2 = kotlinx.coroutines.BuildersKt.async$default(r3, r4, r5, r6, r7, r8)
                r3 = r1
                kotlin.coroutines.Continuation r3 = (kotlin.coroutines.Continuation) r3
                r1.L$0 = r2
                r4 = 1
                r1.label = r4
                java.lang.Object r3 = r10.await(r3)
                if (r3 != r0) goto L60
                return r0
            L60:
                r4 = r1
                kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
                r1.L$0 = r3
                r5 = 2
                r1.label = r5
                java.lang.Object r2 = r2.await(r4)
                if (r2 != r0) goto L6f
                return r0
            L6f:
                r0 = r12
                r12 = r2
            L71:
                kotlin.Pair r12 = kotlin.TuplesKt.to(r3, r12)
                return r12
            */
            throw new UnsupportedOperationException("Method not decompiled: com.coldfriesinoctober.walrus.music.YtMusicApi$likedSongsByAccount$2.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public YtMusicApi$likedSongsByAccount$2(int i, Continuation<? super YtMusicApi$likedSongsByAccount$2> continuation) {
        super(2, continuation);
        this.$maxTracks = i;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new YtMusicApi$likedSongsByAccount$2(this.$maxTracks, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super Pair<? extends List<? extends YtTrack>, ? extends List<? extends YtTrack>>> continuation) {
        return invoke2(coroutineScope, (Continuation<? super Pair<? extends List<YtTrack>, ? extends List<YtTrack>>>) continuation);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super Pair<? extends List<YtTrack>, ? extends List<YtTrack>>> continuation) {
        return ((YtMusicApi$likedSongsByAccount$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                Object coroutineScope = CoroutineScopeKt.coroutineScope(new AnonymousClass1(this.$maxTracks, null), this);
                return coroutineScope == coroutine_suspended ? coroutine_suspended : coroutineScope;
            case 1:
                ResultKt.throwOnFailure(obj);
                return obj;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}

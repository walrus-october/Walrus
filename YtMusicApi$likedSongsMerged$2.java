package com.coldfriesinoctober.walrus.music;

import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: YtMusicApi.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "Lcom/coldfriesinoctober/walrus/music/YtTrack;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.coldfriesinoctober.walrus.music.YtMusicApi$likedSongsMerged$2", f = "YtMusicApi.kt", i = {}, l = {557, 558}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
public final class YtMusicApi$likedSongsMerged$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends YtTrack>>, Object> {
    final /* synthetic */ int $maxTracks;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: YtMusicApi.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "Lcom/coldfriesinoctober/walrus/music/YtTrack;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.coldfriesinoctober.walrus.music.YtMusicApi$likedSongsMerged$2$1", f = "YtMusicApi.kt", i = {0}, l = {564, 564}, m = "invokeSuspend", n = {"b"}, s = {"L$0"})
    /* renamed from: com.coldfriesinoctober.walrus.music.YtMusicApi$likedSongsMerged$2$1, reason: invalid class name */
    /* loaded from: classes5.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends YtTrack>>, Object> {
        final /* synthetic */ int $maxTracks;
        private /* synthetic */ Object L$0;
        Object L$1;
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
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends YtTrack>> continuation) {
            return invoke2(coroutineScope, (Continuation<? super List<YtTrack>>) continuation);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super List<YtTrack>> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0006. Please report as an issue. */
        /* JADX WARN: Removed duplicated region for block: B:10:0x00ab  */
        /* JADX WARN: Removed duplicated region for block: B:23:0x008a A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:24:0x008b  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r13) {
            /*
                Method dump skipped, instructions count: 216
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.coldfriesinoctober.walrus.music.YtMusicApi$likedSongsMerged$2.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public YtMusicApi$likedSongsMerged$2(int i, Continuation<? super YtMusicApi$likedSongsMerged$2> continuation) {
        super(2, continuation);
        this.$maxTracks = i;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new YtMusicApi$likedSongsMerged$2(this.$maxTracks, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends YtTrack>> continuation) {
        return invoke2(coroutineScope, (Continuation<? super List<YtTrack>>) continuation);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super List<YtTrack>> continuation) {
        return ((YtMusicApi$likedSongsMerged$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        List<YtTrack> tracks;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                if (!YtMusicApi.INSTANCE.isLoggedIn()) {
                    return CollectionsKt.emptyList();
                }
                if (!YtMusicApi.INSTANCE.isLoggedIn2()) {
                    this.label = 1;
                    Object likedSongs = YtMusicApi.INSTANCE.likedSongs(this.$maxTracks, this);
                    if (likedSongs != coroutine_suspended) {
                        obj = likedSongs;
                        break;
                    } else {
                        return coroutine_suspended;
                    }
                } else {
                    this.label = 2;
                    Object coroutineScope = CoroutineScopeKt.coroutineScope(new AnonymousClass1(this.$maxTracks, null), this);
                    return coroutineScope == coroutine_suspended ? coroutine_suspended : coroutineScope;
                }
            case 1:
                ResultKt.throwOnFailure(obj);
                break;
            case 2:
                ResultKt.throwOnFailure(obj);
                return obj;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        YtPage ytPage = (YtPage) obj;
        return (ytPage == null || (tracks = ytPage.getTracks()) == null) ? CollectionsKt.emptyList() : tracks;
    }
}

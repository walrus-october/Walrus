package com.coldfriesinoctober.walrus.music;

import androidx.autofill.HintConstants;
import androidx.exifinterface.media.ExifInterface;
import androidx.media3.exoplayer.upstream.CmcdData;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.coldfriesinoctober.walrus.Prefs;
import com.coldfriesinoctober.walrus.WalrusApp;
import com.yausername.youtubedl_android.YoutubeDL;
import com.yausername.youtubedl_android.YoutubeDLRequest;
import java.io.IOException;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlin.text.Charsets;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonArray;
import kotlinx.serialization.json.JsonBuilder;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementBuildersKt;
import kotlinx.serialization.json.JsonElementKt;
import kotlinx.serialization.json.JsonKt;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonObjectBuilder;
import kotlinx.serialization.json.JsonPrimitive;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.mozilla.javascript.ES6Iterator;
import org.schabi.newpipe.extractor.services.youtube.YoutubeParsingHelper;
import org.schabi.newpipe.extractor.stream.Stream;

/* compiled from: YtMusicApi.kt */
@Metadata(d1 = {"\u0000À\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b8\n\u0002\u0018\u0002\n\u0002\b\n\bÇ\u0002\u0018\u00002\u00020\u0001:\u0004»\u0001¼\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J.\u00107\u001a\u0002082\u0006\u00109\u001a\u00020\u00042\u0016\b\u0002\u0010:\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u001bH\u0082@¢\u0006\u0002\u0010;J\u0016\u0010<\u001a\u0002082\u0006\u0010=\u001a\u00020\u0004H\u0082@¢\u0006\u0002\u0010>J\u001e\u0010?\u001a\b\u0012\u0004\u0012\u00020@0%2\b\b\u0002\u0010A\u001a\u00020\u0013H\u0086@¢\u0006\u0002\u0010BJ\u0006\u0010C\u001a\u00020DJ\u0006\u0010E\u001a\u00020DJ\u0006\u0010F\u001a\u00020DJ&\u0010G\u001a\u00020D2\u0006\u0010H\u001a\u00020I2\u0006\u0010J\u001a\u00020\u00042\f\u0010K\u001a\b\u0012\u0004\u0012\u00020M0LH\u0002J&\u0010N\u001a\u00020D2\u0006\u0010H\u001a\u00020I2\u0006\u0010J\u001a\u00020\u00042\f\u0010K\u001a\b\u0012\u0004\u0012\u0002080LH\u0002J\u0016\u0010O\u001a\b\u0012\u0004\u0012\u00020I0%2\u0006\u0010P\u001a\u000208H\u0002J\"\u0010Q\u001a\u0002082\u0006\u0010R\u001a\u00020\u00042\u0006\u0010S\u001a\u00020\u00042\b\u0010T\u001a\u0004\u0018\u00010\u0004H\u0002J\u0012\u0010U\u001a\u0004\u0018\u00010\u00042\u0006\u0010P\u001a\u00020IH\u0002J \u0010V\u001a\u0004\u0018\u00010\u00042\u0014\b\u0002\u0010:\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u001bH\u0002J\u0012\u0010W\u001a\u0004\u0018\u00010\u00042\u0006\u0010X\u001a\u000208H\u0002J\u0012\u0010Y\u001a\u0004\u0018\u00010\u00042\u0006\u0010P\u001a\u000208H\u0002J\u001a\u0010Z\u001a\u0004\u0018\u00010\u00042\u0006\u0010P\u001a\u0002082\u0006\u0010J\u001a\u00020\u0004H\u0002J(\u0010[\u001a\u0004\u0018\u00010\u00042\u0016\b\u0002\u0010:\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u001bH\u0086@¢\u0006\u0002\u0010\\J\u0010\u0010]\u001a\u0004\u0018\u00010\u0004H\u0086@¢\u0006\u0002\u0010^J\u000e\u0010_\u001a\u000206H\u0082@¢\u0006\u0002\u0010^J\u001a\u0010`\u001a\u0004\u0018\u00010\u00042\u0006\u0010a\u001a\u00020\u00042\u0006\u0010J\u001a\u00020\u0004H\u0002J\u001a\u0010b\u001a\u0004\u0018\u00010\u00042\u0006\u0010H\u001a\u00020I2\u0006\u0010J\u001a\u00020\u0004H\u0002J\u0012\u0010c\u001a\u0004\u0018\u00010\u00042\u0006\u0010P\u001a\u000208H\u0002J\u001e\u0010d\u001a\b\u0012\u0004\u0012\u00020@0%2\b\b\u0002\u0010A\u001a\u00020\u0013H\u0086@¢\u0006\u0002\u0010BJ\u001e\u0010e\u001a\b\u0012\u0004\u0012\u00020@0%2\b\b\u0002\u0010A\u001a\u00020\u0013H\u0086@¢\u0006\u0002\u0010BJ*\u0010f\u001a\b\u0012\u0004\u0012\u00020@0%2\f\u0010g\u001a\b\u0012\u0004\u0012\u00020@0%2\f\u0010h\u001a\b\u0012\u0004\u0012\u00020@0%H\u0002J\u0006\u0010i\u001a\u00020DJ\u001a\u0010j\u001a\u0004\u0018\u00010k2\b\b\u0002\u0010l\u001a\u00020\u0013H\u0086@¢\u0006\u0002\u0010BJ0\u0010m\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020@0%\u0012\n\u0012\b\u0012\u0004\u0012\u00020@0%022\b\b\u0002\u0010l\u001a\u00020\u0013H\u0086@¢\u0006\u0002\u0010BJ\u001e\u0010n\u001a\b\u0012\u0004\u0012\u00020@0%2\b\b\u0002\u0010l\u001a\u00020\u0013H\u0086@¢\u0006\u0002\u0010BJ\u001c\u0010o\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u001b2\u0006\u0010V\u001a\u00020\u0004H\u0002J\u0017\u0010p\u001a\u0004\u0018\u00010\u00132\u0006\u0010q\u001a\u00020\u0004H\u0002¢\u0006\u0002\u0010rJ\u001a\u0010s\u001a\u0004\u0018\u00010t2\u0006\u0010X\u001a\u0002082\u0006\u0010u\u001a\u00020vH\u0002J\u0016\u0010w\u001a\b\u0012\u0004\u0012\u00020@0%2\u0006\u0010P\u001a\u00020IH\u0002J\u0012\u0010x\u001a\u0004\u0018\u00010@2\u0006\u0010X\u001a\u000208H\u0002J\u0016\u0010y\u001a\b\u0012\u0004\u0012\u00020z0%2\u0006\u0010P\u001a\u00020IH\u0002J\u0012\u0010{\u001a\u0004\u0018\u00010@2\u0006\u0010X\u001a\u000208H\u0002J\u0012\u0010|\u001a\u0004\u0018\u00010@2\u0006\u0010X\u001a\u000208H\u0002J\u0016\u0010}\u001a\b\u0012\u0004\u0012\u00020@0%2\u0006\u0010P\u001a\u00020IH\u0002J\u0012\u0010~\u001a\u0004\u0018\u00010@2\u0006\u0010X\u001a\u000208H\u0002J\u008c\u0001\u0010\u007f\u001a\u0002082\u0007\u0010\u0080\u0001\u001a\u00020\u00042\u0007\u0010\u0081\u0001\u001a\u0002082\u0007\u0010\u0082\u0001\u001a\u00020\u00042\u0007\u0010\u0083\u0001\u001a\u00020\u00042\u0007\u0010\u0084\u0001\u001a\u00020\u00042\t\b\u0002\u0010\u0085\u0001\u001a\u00020\u00042\t\b\u0002\u0010\u0086\u0001\u001a\u00020\u00042\n\b\u0002\u0010T\u001a\u0004\u0018\u00010\u00042\t\b\u0002\u0010\u0087\u0001\u001a\u00020\u00132\t\b\u0002\u0010\u0088\u0001\u001a\u00020\u001f2\u0016\b\u0002\u0010:\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u001bH\u0082@¢\u0006\u0003\u0010\u0089\u0001J\u0012\u0010\u008a\u0001\u001a\u00020D2\t\u0010\u008b\u0001\u001a\u0004\u0018\u00010\u0004J#\u0010\u008c\u0001\u001a\u00020D2\u000f\u0010\u008d\u0001\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040%2\t\b\u0002\u0010\u008e\u0001\u001a\u00020\u0013J\u0012\u0010\u008f\u0001\u001a\u00020\u001f2\u0007\u0010\u0090\u0001\u001a\u000204H\u0002J-\u0010\u0091\u0001\u001a\u00020\u001f2\u0007\u0010\u008b\u0001\u001a\u00020\u00042\u0007\u0010\u0092\u0001\u001a\u00020\u001f2\t\b\u0002\u0010\u0093\u0001\u001a\u00020\u0013H\u0086@¢\u0006\u0003\u0010\u0094\u0001J)\u0010\u0095\u0001\u001a\b\u0012\u0004\u0012\u00020@0%2\u0007\u0010\u008b\u0001\u001a\u00020\u00042\b\b\u0002\u0010A\u001a\u00020\u0013H\u0086@¢\u0006\u0003\u0010\u0096\u0001J\u0018\u0010\u0097\u0001\u001a\u0002042\u0007\u0010\u008b\u0001\u001a\u00020\u0004H\u0086@¢\u0006\u0002\u0010>J\u0018\u0010\u0098\u0001\u001a\u0002042\u0007\u0010\u008b\u0001\u001a\u00020\u0004H\u0086@¢\u0006\u0002\u0010>J\u0012\u0010\u0099\u0001\u001a\u0002042\u0007\u0010\u008b\u0001\u001a\u00020\u0004H\u0002J9\u0010\u009a\u0001\u001a\u0004\u0018\u0001042\u0007\u0010\u008b\u0001\u001a\u00020\u00042\u0007\u0010\u009b\u0001\u001a\u00020&2\b\u0010T\u001a\u0004\u0018\u00010\u00042\t\b\u0002\u0010\u009c\u0001\u001a\u00020\u001fH\u0082@¢\u0006\u0003\u0010\u009d\u0001J!\u0010\u009e\u0001\u001a\u0004\u0018\u00010\u00042\u0014\b\u0002\u0010:\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u001bH\u0002J,\u0010\u009f\u0001\u001a\u0004\u0018\u00010\u00042\u0014\b\u0002\u0010:\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u001b2\t\b\u0002\u0010\u0085\u0001\u001a\u00020\u0004H\u0002J\u0011\u0010 \u0001\u001a\u0004\u0018\u00010\u00042\u0006\u0010V\u001a\u00020\u0004J)\u0010¡\u0001\u001a\b\u0012\u0004\u0012\u00020t0%2\u0007\u0010¢\u0001\u001a\u00020\u00042\b\b\u0002\u0010A\u001a\u00020\u0013H\u0086@¢\u0006\u0003\u0010\u0096\u0001J)\u0010£\u0001\u001a\b\u0012\u0004\u0012\u00020t0%2\u0007\u0010¢\u0001\u001a\u00020\u00042\b\b\u0002\u0010A\u001a\u00020\u0013H\u0086@¢\u0006\u0003\u0010\u0096\u0001J8\u0010¤\u0001\u001a\b\u0012\u0004\u0012\u00020t0%2\u0007\u0010¢\u0001\u001a\u00020\u00042\u0006\u0010u\u001a\u00020v2\u0007\u0010¥\u0001\u001a\u00020\u00042\u0006\u0010A\u001a\u00020\u0013H\u0082@¢\u0006\u0003\u0010¦\u0001J)\u0010§\u0001\u001a\b\u0012\u0004\u0012\u00020z0%2\u0007\u0010¢\u0001\u001a\u00020\u00042\b\b\u0002\u0010A\u001a\u00020\u0013H\u0086@¢\u0006\u0003\u0010\u0096\u0001J)\u0010¨\u0001\u001a\b\u0012\u0004\u0012\u00020@0%2\u0007\u0010¢\u0001\u001a\u00020\u00042\b\b\u0002\u0010A\u001a\u00020\u0013H\u0086@¢\u0006\u0003\u0010\u0096\u0001J\t\u0010©\u0001\u001a\u0004\u0018\u00010\u0004J\u000f\u0010ª\u0001\u001a\u00020D2\u0006\u0010V\u001a\u00020\u0004J\u000f\u0010«\u0001\u001a\u00020D2\u0006\u0010V\u001a\u00020\u0004J<\u0010¬\u0001\u001a\u0004\u0018\u00010k2\u0006\u00109\u001a\u00020\u00042\b\b\u0002\u0010l\u001a\u00020\u00132\u0016\b\u0002\u0010:\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u001bH\u0086@¢\u0006\u0003\u0010\u00ad\u0001J\u0018\u0010®\u0001\u001a\u00020D2\u0007\u0010\u008b\u0001\u001a\u00020\u0004H\u0086@¢\u0006\u0002\u0010>J\u0007\u0010¯\u0001\u001a\u00020DJ\u000e\u00105\u001a\u000206H\u0082@¢\u0006\u0002\u0010^J\u0017\u0010°\u0001\u001a\u0004\u0018\u00010M*\u00020I2\u0006\u0010J\u001a\u00020\u0004H\u0002J\u0017\u0010°\u0001\u001a\u0004\u0018\u00010M*\u0002082\u0006\u0010J\u001a\u00020\u0004H\u0002J\u000f\u0010±\u0001\u001a\u0004\u0018\u000108*\u00020IH\u0002J!\u0010²\u0001\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u000402*\u00030³\u0001H\u0082@¢\u0006\u0003\u0010´\u0001J\r\u0010µ\u0001\u001a\u00020\u0004*\u00020\u0004H\u0002J\u001d\u0010¶\u0001\u001a\u0004\u0018\u00010\u0013*\u0002082\u0006\u0010J\u001a\u00020\u0004H\u0002¢\u0006\u0003\u0010·\u0001J\r\u0010¸\u0001\u001a\u00020\u001f*\u00020\u0004H\u0002J\u0017\u0010¹\u0001\u001a\u0004\u0018\u000108*\u00020I2\u0006\u0010J\u001a\u00020\u0004H\u0002J\u0017\u0010¹\u0001\u001a\u0004\u0018\u000108*\u0002082\u0006\u0010J\u001a\u00020\u0004H\u0002J\u0017\u0010º\u0001\u001a\u0004\u0018\u00010\u0004*\u00020I2\u0006\u0010J\u001a\u00020\u0004H\u0002J\u0017\u0010º\u0001\u001a\u0004\u0018\u00010\u0004*\u0002082\u0006\u0010J\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\"\u0010\r\u001a\u0004\u0018\u00010\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u0004@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u0004\u0018\u00010\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u0004@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0011\u0010\u0012\u001a\u00020\u00138F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\"\u0010\u0016\u001a\u0004\u0018\u00010\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u0004@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000fR\"\u0010\u0018\u001a\u0004\u0018\u00010\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u0004@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u000fR\u001a\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u001e\u001a\u00020\u001f8F¢\u0006\u0006\u001a\u0004\b\u001e\u0010 R\u0011\u0010!\u001a\u00020\u001f8F¢\u0006\u0006\u001a\u0004\b!\u0010 R\u000e\u0010\"\u001a\u00020#X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010$\u001a\b\u0012\u0004\u0012\u00020&0%X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020(X\u0082\u0004¢\u0006\u0002\n\u0000RN\u0010)\u001aB\u0012\f\u0012\n +*\u0004\u0018\u00010\u00040\u0004\u0012\f\u0012\n +*\u0004\u0018\u00010\u001f0\u001f +* \u0012\f\u0012\n +*\u0004\u0018\u00010\u00040\u0004\u0012\f\u0012\n +*\u0004\u0018\u00010\u001f0\u001f\u0018\u00010*0*X\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010,\u001a\u0004\u0018\u00010\u00048F¢\u0006\u0006\u001a\u0004\b-\u0010\u000fR\u001a\u0010.\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010/\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R&\u00100\u001a\u001a\u0012\u0004\u0012\u00020\u0004\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u000203\u0012\u0004\u0012\u0002040201X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u00105\u001a\u0004\u0018\u000106X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006½\u0001"}, d2 = {"Lcom/coldfriesinoctober/walrus/music/YtMusicApi;", "", "()V", "FALLBACK_WEB_KEY", "", "FALLBACK_WEB_VERSION", "JSON_MEDIA_TYPE", "Lokhttp3/MediaType;", "MUSIC_API", "WEB_USER_AGENT", "YOUTUBE_API", "YOUTUBE_MUSIC_ORIGIN", "<set-?>", "accountAvatar", "getAccountAvatar", "()Ljava/lang/String;", "accountAvatar2", "getAccountAvatar2", "accountCount", "", "getAccountCount", "()I", "accountName", "getAccountName", "accountName2", "getAccountName2", "clientIds", "", "http", "Lokhttp3/OkHttpClient;", "isLoggedIn", "", "()Z", "isLoggedIn2", "json", "Lkotlinx/serialization/json/Json;", "playerClients", "", "Lcom/coldfriesinoctober/walrus/music/YtMusicApi$PlayerClient;", "prefetchScope", "Lkotlinx/coroutines/CoroutineScope;", "prefetching", "Ljava/util/concurrent/ConcurrentHashMap$KeySetView;", "kotlin.jvm.PlatformType", "primarySapisid", "getPrimarySapisid", "sessionCookies", "sessionCookies2", "streamCache", "Ljava/util/concurrent/ConcurrentHashMap;", "Lkotlin/Pair;", "", "Lcom/coldfriesinoctober/walrus/music/YtStream;", "webConfig", "Lcom/coldfriesinoctober/walrus/music/YtMusicApi$WebConfig;", "browse", "Lkotlinx/serialization/json/JsonObject;", "browseId", "cookies", "(Ljava/lang/String;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "browseContinuation", "token", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "charts", "Lcom/coldfriesinoctober/walrus/music/YtTrack;", "limit", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "clearSession", "", "clearSession2", "clearStreamCache", "collectArrays", "element", "Lkotlinx/serialization/json/JsonElement;", "key", "output", "", "Lkotlinx/serialization/json/JsonArray;", "collectObjects", "containersFor", "root", "contextBlock", HintConstants.AUTOFILL_HINT_NAME, "version", "visitorData", "continuationToken", "cookieHeader", "directWatchVideoId", "renderer", "extractHeaderArtwork", "extractHeaderText", "fetchAccountName", "(Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchAccountName2", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchWebConfig", "findConfig", "html", "findString", "headerSubtitle", "homeSongs", "homeSongsMerged", "interleave", CmcdData.Factory.OBJECT_TYPE_AUDIO_ONLY, "b", "invalidateWebConfig", "likedSongs", "Lcom/coldfriesinoctober/walrus/music/YtPage;", "maxTracks", "likedSongsByAccount", "likedSongsMerged", "parseCookies", "parseDuration", ES6Iterator.VALUE_PROPERTY, "(Ljava/lang/String;)Ljava/lang/Integer;", "parseEntity", "Lcom/coldfriesinoctober/walrus/music/YtEntity;", "kind", "Lcom/coldfriesinoctober/walrus/music/YtEntityKind;", "parseHomeFeedSongs", "parsePanelSong", "parsePlaylistRenderers", "Lcom/coldfriesinoctober/walrus/music/YtPlaylistSummary;", "parsePlaylistVideo", "parseSong", "parseSongRenderers", "parseTwoRowSong", "post", "url", TtmlNode.TAG_BODY, "clientName", "clientVersion", "userAgent", "origin", "referer", "maxAttempts", "authenticated", "(Ljava/lang/String;Lkotlinx/serialization/json/JsonObject;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IZLjava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "prefetch", YoutubeParsingHelper.VIDEO_ID, "prefetchAll", "videoIds", "max", "probeStream", "stream", "rateSong", "like", "account", "(Ljava/lang/String;ZILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "related", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resolveStream", "resolveStreamFast", "resolveViaYtDlp", "resolveWithClient", "client", "probe", "(Ljava/lang/String;Lcom/coldfriesinoctober/walrus/music/YtMusicApi$PlayerClient;Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sapisid", "sapisidHash", "sapisidValue", "searchAlbums", "query", "searchArtists", "searchEntities", "filter", "(Ljava/lang/String;Lcom/coldfriesinoctober/walrus/music/YtEntityKind;Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "searchPlaylists", "searchTracks", "sessionCookieHeader", "setSession", "setSession2", "trackListPage", "(Ljava/lang/String;ILjava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "warmStream", "warmUp", "array", "asObject", "awaitBody", "Lokhttp3/Call;", "(Lokhttp3/Call;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "highResolutionArtwork", "int", "(Lkotlinx/serialization/json/JsonObject;Ljava/lang/String;)Ljava/lang/Integer;", "isLikelyArtistDetail", "obj", "string", "PlayerClient", "WebConfig", "app_debug"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class YtMusicApi {
    private static final String FALLBACK_WEB_KEY = "AIzaSyC9XL3ZjWddXya6X74dJoCTL-WEYFDNX30";
    private static final String FALLBACK_WEB_VERSION = "1.20260707.12.00";
    private static final String MUSIC_API = "https://music.youtube.com/youtubei/v1";
    private static final String WEB_USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:140.0) Gecko/20100101 Firefox/140.0";
    private static final String YOUTUBE_API = "https://www.youtube.com/youtubei/v1";
    private static final String YOUTUBE_MUSIC_ORIGIN = "https://music.youtube.com";
    private static volatile String accountAvatar;
    private static volatile String accountAvatar2;
    private static volatile String accountName;
    private static volatile String accountName2;
    private static volatile WebConfig webConfig;
    public static final YtMusicApi INSTANCE = new YtMusicApi();
    private static volatile Map<String, String> sessionCookies = MapsKt.emptyMap();
    private static volatile Map<String, String> sessionCookies2 = MapsKt.emptyMap();
    private static final OkHttpClient http = new OkHttpClient.Builder().connectTimeout(8, TimeUnit.SECONDS).readTimeout(15, TimeUnit.SECONDS).build();
    private static final Json json = JsonKt.Json$default(null, new Function1<JsonBuilder, Unit>() { // from class: com.coldfriesinoctober.walrus.music.YtMusicApi$json$1
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(JsonBuilder jsonBuilder) {
            invoke2(jsonBuilder);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(JsonBuilder Json) {
            Intrinsics.checkNotNullParameter(Json, "$this$Json");
            Json.setIgnoreUnknownKeys(true);
        }
    }, 1, null);
    private static final Map<String, String> clientIds = MapsKt.mapOf(TuplesKt.to("WEB_REMIX", "67"), TuplesKt.to("IOS", "5"), TuplesKt.to("IOS_MUSIC", "26"), TuplesKt.to("ANDROID", ExifInterface.GPS_MEASUREMENT_3D), TuplesKt.to("ANDROID_MUSIC", "21"), TuplesKt.to("ANDROID_TESTSUITE", "30"), TuplesKt.to("TVHTML5", "7"), TuplesKt.to("TVHTML5_SIMPLY_EMBEDDED_PLAYER", "85"), TuplesKt.to("ANDROID_VR", "28"), TuplesKt.to("MWEB", "62"));
    private static final List<PlayerClient> playerClients = CollectionsKt.listOf((Object[]) new PlayerClient[]{new PlayerClient("ANDROID_VR", "1.37", "AIzaSyD-p045F_WzU-vA_YgX20SCx4KAo", "com.google.android.apps.youtube.vr.oculus/1.37 (Linux; U; Android 12; en_US; Quest 3; Build/SQ3A.220605.009.A1; Cronet/107.0.5284.2)", "Android", "12", "Oculus", "Quest 3", "32"), new PlayerClient("TVHTML5", "7.20260308.08.00", "AIzaSyAO_FJ2SlqAz8GlBg1fA54p0wDE7Xk80mU", "Mozilla/5.0 (SMART-TV; Linux; Tizen 6.0) AppleWebKit/537.36 (KHTML, like Gecko) SamsungBrowser/4.0 Chrome/76.0.3809.146 TV Safari/537.36", null, null, null, null, null, 496, null), new PlayerClient("TVHTML5_SIMPLY_EMBEDDED_PLAYER", "2.0", "AIzaSyAO_FJ2SlqAz8GlBg1fA54p0wDE7Xk80mU", "Mozilla/5.0 (SMART-TV; Linux; Tizen 6.0) AppleWebKit/537.36 (KHTML, like Gecko) SamsungBrowser/4.0 Chrome/76.0.3809.146 TV Safari/537.36", null, null, null, null, null, 496, null), new PlayerClient("ANDROID_TESTSUITE", "1.9", "AIzaSyD-p045F_WzU-vA_YgX20SCx4KAo", "com.google.android.youtube/1.9 (Linux; U; Android 12) gzip", "Android", "12", null, null, null, 448, null), new PlayerClient("IOS_MUSIC", "7.27.0", "AIzaSyB-63vPrdThhKuerbB2N_l7Kwwcxj6yUAc", "com.google.ios.youtubemusic/7.27.0 (iPhone16,2; U; CPU iOS 17_5_1 like Mac OS X;)", "iOS", "17.5.1.21F90", "Apple", "iPhone16,2", 0 == true ? 1 : 0, 256, null), new PlayerClient("ANDROID_MUSIC", "7.27.52", "AIzaSyA8eiZmM1FaDVjRy-df2KTyQ_vz_yYM39w", "com.google.android.apps.youtube.music/7.27.52 (Linux; U; Android 14; en_US; Pixel 8; Build/UD1A.230803.041) gzip", "Android", "14", "Google", "Pixel 8", "34"), new PlayerClient("ANDROID", "21.26.364", "AIzaSyA8eiZmM1FaDVjRy-df2KTyQ_vz_yYM39w", "com.google.android.youtube/21.26.364 (Linux; U; Android 11) gzip", "Android", "11", null, null, null, 448, 0 == true ? 1 : 0)});
    private static final MediaType JSON_MEDIA_TYPE = MediaType.INSTANCE.get("application/json; charset=utf-8");
    private static final ConcurrentHashMap<String, Pair<Long, YtStream>> streamCache = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap.KeySetView<String, Boolean> prefetching = ConcurrentHashMap.newKeySet();
    private static final CoroutineScope prefetchScope = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO().plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null)));
    public static final int $stable = 8;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: YtMusicApi.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001Ba\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\fJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003Jm\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020%HÖ\u0001J\t\u0010&\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000e¨\u0006'"}, d2 = {"Lcom/coldfriesinoctober/walrus/music/YtMusicApi$PlayerClient;", "", HintConstants.AUTOFILL_HINT_NAME, "", "version", "apiKey", "userAgent", "osName", "osVersion", "deviceMake", "deviceModel", "androidSdkVersion", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAndroidSdkVersion", "()Ljava/lang/String;", "getApiKey", "getDeviceMake", "getDeviceModel", "getName", "getOsName", "getOsVersion", "getUserAgent", "getVersion", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "", "toString", "app_debug"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* data */ class PlayerClient {
        private final String androidSdkVersion;
        private final String apiKey;
        private final String deviceMake;
        private final String deviceModel;
        private final String name;
        private final String osName;
        private final String osVersion;
        private final String userAgent;
        private final String version;

        public PlayerClient(String name, String version, String apiKey, String userAgent, String str, String str2, String str3, String str4, String str5) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(version, "version");
            Intrinsics.checkNotNullParameter(apiKey, "apiKey");
            Intrinsics.checkNotNullParameter(userAgent, "userAgent");
            this.name = name;
            this.version = version;
            this.apiKey = apiKey;
            this.userAgent = userAgent;
            this.osName = str;
            this.osVersion = str2;
            this.deviceMake = str3;
            this.deviceModel = str4;
            this.androidSdkVersion = str5;
        }

        public /* synthetic */ PlayerClient(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, str3, str4, (i & 16) != 0 ? null : str5, (i & 32) != 0 ? null : str6, (i & 64) != 0 ? null : str7, (i & 128) != 0 ? null : str8, (i & 256) != 0 ? null : str9);
        }

        /* renamed from: component1, reason: from getter */
        public final String getName() {
            return this.name;
        }

        /* renamed from: component2, reason: from getter */
        public final String getVersion() {
            return this.version;
        }

        /* renamed from: component3, reason: from getter */
        public final String getApiKey() {
            return this.apiKey;
        }

        /* renamed from: component4, reason: from getter */
        public final String getUserAgent() {
            return this.userAgent;
        }

        /* renamed from: component5, reason: from getter */
        public final String getOsName() {
            return this.osName;
        }

        /* renamed from: component6, reason: from getter */
        public final String getOsVersion() {
            return this.osVersion;
        }

        /* renamed from: component7, reason: from getter */
        public final String getDeviceMake() {
            return this.deviceMake;
        }

        /* renamed from: component8, reason: from getter */
        public final String getDeviceModel() {
            return this.deviceModel;
        }

        /* renamed from: component9, reason: from getter */
        public final String getAndroidSdkVersion() {
            return this.androidSdkVersion;
        }

        public final PlayerClient copy(String name, String version, String apiKey, String userAgent, String osName, String osVersion, String deviceMake, String deviceModel, String androidSdkVersion) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(version, "version");
            Intrinsics.checkNotNullParameter(apiKey, "apiKey");
            Intrinsics.checkNotNullParameter(userAgent, "userAgent");
            return new PlayerClient(name, version, apiKey, userAgent, osName, osVersion, deviceMake, deviceModel, androidSdkVersion);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PlayerClient)) {
                return false;
            }
            PlayerClient playerClient = (PlayerClient) other;
            return Intrinsics.areEqual(this.name, playerClient.name) && Intrinsics.areEqual(this.version, playerClient.version) && Intrinsics.areEqual(this.apiKey, playerClient.apiKey) && Intrinsics.areEqual(this.userAgent, playerClient.userAgent) && Intrinsics.areEqual(this.osName, playerClient.osName) && Intrinsics.areEqual(this.osVersion, playerClient.osVersion) && Intrinsics.areEqual(this.deviceMake, playerClient.deviceMake) && Intrinsics.areEqual(this.deviceModel, playerClient.deviceModel) && Intrinsics.areEqual(this.androidSdkVersion, playerClient.androidSdkVersion);
        }

        public final String getAndroidSdkVersion() {
            return this.androidSdkVersion;
        }

        public final String getApiKey() {
            return this.apiKey;
        }

        public final String getDeviceMake() {
            return this.deviceMake;
        }

        public final String getDeviceModel() {
            return this.deviceModel;
        }

        public final String getName() {
            return this.name;
        }

        public final String getOsName() {
            return this.osName;
        }

        public final String getOsVersion() {
            return this.osVersion;
        }

        public final String getUserAgent() {
            return this.userAgent;
        }

        public final String getVersion() {
            return this.version;
        }

        public int hashCode() {
            return (((((((((((((((this.name.hashCode() * 31) + this.version.hashCode()) * 31) + this.apiKey.hashCode()) * 31) + this.userAgent.hashCode()) * 31) + (this.osName == null ? 0 : this.osName.hashCode())) * 31) + (this.osVersion == null ? 0 : this.osVersion.hashCode())) * 31) + (this.deviceMake == null ? 0 : this.deviceMake.hashCode())) * 31) + (this.deviceModel == null ? 0 : this.deviceModel.hashCode())) * 31) + (this.androidSdkVersion != null ? this.androidSdkVersion.hashCode() : 0);
        }

        public String toString() {
            return "PlayerClient(name=" + this.name + ", version=" + this.version + ", apiKey=" + this.apiKey + ", userAgent=" + this.userAgent + ", osName=" + this.osName + ", osVersion=" + this.osVersion + ", deviceMake=" + this.deviceMake + ", deviceModel=" + this.deviceModel + ", androidSdkVersion=" + this.androidSdkVersion + ")";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: YtMusicApi.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J)\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/coldfriesinoctober/walrus/music/YtMusicApi$WebConfig;", "", "apiKey", "", "clientVersion", "visitorData", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getApiKey", "()Ljava/lang/String;", "getClientVersion", "getVisitorData", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "app_debug"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* data */ class WebConfig {
        private final String apiKey;
        private final String clientVersion;
        private final String visitorData;

        public WebConfig(String apiKey, String clientVersion, String str) {
            Intrinsics.checkNotNullParameter(apiKey, "apiKey");
            Intrinsics.checkNotNullParameter(clientVersion, "clientVersion");
            this.apiKey = apiKey;
            this.clientVersion = clientVersion;
            this.visitorData = str;
        }

        public static /* synthetic */ WebConfig copy$default(WebConfig webConfig, String str, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = webConfig.apiKey;
            }
            if ((i & 2) != 0) {
                str2 = webConfig.clientVersion;
            }
            if ((i & 4) != 0) {
                str3 = webConfig.visitorData;
            }
            return webConfig.copy(str, str2, str3);
        }

        /* renamed from: component1, reason: from getter */
        public final String getApiKey() {
            return this.apiKey;
        }

        /* renamed from: component2, reason: from getter */
        public final String getClientVersion() {
            return this.clientVersion;
        }

        /* renamed from: component3, reason: from getter */
        public final String getVisitorData() {
            return this.visitorData;
        }

        public final WebConfig copy(String apiKey, String clientVersion, String visitorData) {
            Intrinsics.checkNotNullParameter(apiKey, "apiKey");
            Intrinsics.checkNotNullParameter(clientVersion, "clientVersion");
            return new WebConfig(apiKey, clientVersion, visitorData);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof WebConfig)) {
                return false;
            }
            WebConfig webConfig = (WebConfig) other;
            return Intrinsics.areEqual(this.apiKey, webConfig.apiKey) && Intrinsics.areEqual(this.clientVersion, webConfig.clientVersion) && Intrinsics.areEqual(this.visitorData, webConfig.visitorData);
        }

        public final String getApiKey() {
            return this.apiKey;
        }

        public final String getClientVersion() {
            return this.clientVersion;
        }

        public final String getVisitorData() {
            return this.visitorData;
        }

        public int hashCode() {
            return (((this.apiKey.hashCode() * 31) + this.clientVersion.hashCode()) * 31) + (this.visitorData == null ? 0 : this.visitorData.hashCode());
        }

        public String toString() {
            return "WebConfig(apiKey=" + this.apiKey + ", clientVersion=" + this.clientVersion + ", visitorData=" + this.visitorData + ")";
        }
    }

    private YtMusicApi() {
    }

    private final JsonArray array(JsonElement jsonElement, String str) {
        JsonObject jsonObject = jsonElement instanceof JsonObject ? (JsonObject) jsonElement : null;
        if (jsonObject != null) {
            return array(jsonObject, str);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final JsonArray array(JsonObject jsonObject, String str) {
        Object obj = jsonObject.get((Object) str);
        if (obj instanceof JsonArray) {
            return (JsonArray) obj;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final JsonObject asObject(JsonElement jsonElement) {
        if (jsonElement instanceof JsonObject) {
            return (JsonObject) jsonElement;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object awaitBody(final Call call, Continuation<? super Pair<Integer, String>> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        final CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
        cancellableContinuationImpl2.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: com.coldfriesinoctober.walrus.music.YtMusicApi$awaitBody$2$1
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
        call.enqueue(new Callback() { // from class: com.coldfriesinoctober.walrus.music.YtMusicApi$awaitBody$2$2
            @Override // okhttp3.Callback
            public void onFailure(Call call2, IOException e) {
                Intrinsics.checkNotNullParameter(call2, "call");
                Intrinsics.checkNotNullParameter(e, "e");
                CancellableContinuation<Pair<Integer, String>> cancellableContinuation = cancellableContinuationImpl2;
                Result.Companion companion = Result.INSTANCE;
                cancellableContinuation.resumeWith(Result.m6535constructorimpl(ResultKt.createFailure(e)));
            }

            @Override // okhttp3.Callback
            public void onResponse(Call call2, Response response) {
                Object m6535constructorimpl;
                Intrinsics.checkNotNullParameter(call2, "call");
                Intrinsics.checkNotNullParameter(response, "response");
                try {
                    Result.Companion companion = Result.INSTANCE;
                    YtMusicApi$awaitBody$2$2 ytMusicApi$awaitBody$2$2 = this;
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
                cancellableContinuationImpl2.resumeWith(m6535constructorimpl);
            }
        });
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00f1 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object browse(java.lang.String r20, java.util.Map<java.lang.String, java.lang.String> r21, kotlin.coroutines.Continuation<? super kotlinx.serialization.json.JsonObject> r22) {
        /*
            Method dump skipped, instructions count: 254
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coldfriesinoctober.walrus.music.YtMusicApi.browse(java.lang.String, java.util.Map, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object browse$default(YtMusicApi ytMusicApi, String str, Map map, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            map = null;
        }
        return ytMusicApi.browse(str, map, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00e5 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object browseContinuation(java.lang.String r23, kotlin.coroutines.Continuation<? super kotlinx.serialization.json.JsonObject> r24) {
        /*
            Method dump skipped, instructions count: 242
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coldfriesinoctober.walrus.music.YtMusicApi.browseContinuation(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object charts$default(YtMusicApi ytMusicApi, int i, Continuation continuation, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 30;
        }
        return ytMusicApi.charts(i, continuation);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void collectArrays(JsonElement element, String key, List<JsonArray> output) {
        if (!(element instanceof JsonObject)) {
            if (element instanceof JsonArray) {
                Iterator it = ((Iterable) element).iterator();
                while (it.hasNext()) {
                    INSTANCE.collectArrays((JsonElement) it.next(), key, output);
                }
                return;
            }
            return;
        }
        for (Map.Entry entry : ((Map) element).entrySet()) {
            String str = (String) entry.getKey();
            JsonElement jsonElement = (JsonElement) entry.getValue();
            if (Intrinsics.areEqual(str, key) && (jsonElement instanceof JsonArray)) {
                output.add(jsonElement);
            }
            INSTANCE.collectArrays(jsonElement, key, output);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void collectObjects(JsonElement element, String key, List<JsonObject> output) {
        if (!(element instanceof JsonObject)) {
            if (element instanceof JsonArray) {
                Iterator it = ((Iterable) element).iterator();
                while (it.hasNext()) {
                    INSTANCE.collectObjects((JsonElement) it.next(), key, output);
                }
                return;
            }
            return;
        }
        for (Map.Entry entry : ((Map) element).entrySet()) {
            String str = (String) entry.getKey();
            JsonElement jsonElement = (JsonElement) entry.getValue();
            if (Intrinsics.areEqual(str, key) && (jsonElement instanceof JsonObject)) {
                output.add(jsonElement);
            }
            INSTANCE.collectObjects(jsonElement, key, output);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<JsonElement> containersFor(JsonObject root) {
        Object obj;
        ArrayList arrayList;
        JsonArray jsonArray;
        JsonObject obj2;
        ArrayList arrayList2 = new ArrayList();
        Iterator it = CollectionsKt.listOf((Object[]) new String[]{"musicPlaylistShelfRenderer", "musicPlaylistShelfContinuation", "playlistVideoListRenderer", "playlistVideoListContinuation"}).iterator();
        while (it.hasNext()) {
            collectObjects(root, (String) it.next(), arrayList2);
        }
        if (!arrayList2.isEmpty()) {
            return arrayList2;
        }
        ArrayList arrayList3 = new ArrayList();
        collectObjects(root, "musicShelfRenderer", arrayList3);
        Iterator it2 = arrayList3.iterator();
        while (true) {
            if (!it2.hasNext()) {
                obj = null;
                break;
            }
            obj = it2.next();
            if (!INSTANCE.parseSongRenderers((JsonObject) obj).isEmpty()) {
                break;
            }
        }
        JsonObject jsonObject = (JsonObject) obj;
        if (jsonObject != null) {
            return CollectionsKt.listOf(jsonObject);
        }
        JsonObject obj3 = obj(root, "continuationContents");
        if (obj3 != null && (obj2 = obj(obj3, "musicShelfContinuation")) != null) {
            return CollectionsKt.listOf(obj2);
        }
        List listOf = CollectionsKt.listOf((Object[]) new String[]{"onResponseReceivedActions", "onResponseReceivedEndpoints", "onResponseReceivedCommands"});
        ArrayList arrayList4 = new ArrayList();
        Iterator it3 = listOf.iterator();
        while (it3.hasNext()) {
            JsonArray array = INSTANCE.array(root, (String) it3.next());
            if (array == null) {
                array = CollectionsKt.emptyList();
            }
            CollectionsKt.addAll(arrayList4, array);
        }
        ArrayList<JsonElement> arrayList5 = arrayList4;
        ArrayList arrayList6 = new ArrayList();
        for (JsonElement jsonElement : arrayList5) {
            JsonObject obj4 = INSTANCE.obj(jsonElement, "appendContinuationItemsAction");
            if (obj4 == null) {
                obj4 = INSTANCE.obj(jsonElement, "reloadContinuationItemsCommand");
            }
            if (obj4 != null) {
                arrayList = arrayList2;
                jsonArray = INSTANCE.array(obj4, "continuationItems");
            } else {
                arrayList = arrayList2;
                jsonArray = null;
            }
            if (jsonArray != null) {
                arrayList6.add(jsonArray);
            }
            arrayList2 = arrayList;
        }
        return arrayList6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final JsonObject contextBlock(String name, String version, String visitorData) {
        JsonObjectBuilder jsonObjectBuilder = new JsonObjectBuilder();
        JsonObjectBuilder jsonObjectBuilder2 = new JsonObjectBuilder();
        JsonElementBuildersKt.put(jsonObjectBuilder2, "clientName", name);
        JsonElementBuildersKt.put(jsonObjectBuilder2, "clientVersion", version);
        JsonElementBuildersKt.put(jsonObjectBuilder2, "hl", "en");
        JsonElementBuildersKt.put(jsonObjectBuilder2, "gl", "US");
        String str = visitorData;
        if (!(str == null || StringsKt.isBlank(str))) {
            JsonElementBuildersKt.put(jsonObjectBuilder2, "visitorData", visitorData);
        }
        Unit unit = Unit.INSTANCE;
        jsonObjectBuilder.put("client", jsonObjectBuilder2.build());
        return jsonObjectBuilder.build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String continuationToken(JsonElement root) {
        String str;
        ArrayList arrayList = new ArrayList();
        collectObjects(root, "continuationCommand", arrayList);
        Iterator it = arrayList.iterator();
        while (true) {
            if (!it.hasNext()) {
                str = null;
                break;
            }
            str = INSTANCE.string((JsonObject) it.next(), "token");
            if (str == null || !(!StringsKt.isBlank(str))) {
                str = null;
            }
            if (str != null) {
                break;
            }
        }
        if (str != null) {
            return str;
        }
        ArrayList arrayList2 = new ArrayList();
        collectObjects(root, "nextContinuationData", arrayList2);
        Iterator it2 = arrayList2.iterator();
        while (it2.hasNext()) {
            String string = INSTANCE.string((JsonObject) it2.next(), "continuation");
            if (string == null || !(!StringsKt.isBlank(string))) {
                string = null;
            }
            if (string != null) {
                return string;
            }
        }
        return null;
    }

    private final String cookieHeader(Map<String, String> cookies) {
        if (cookies.isEmpty()) {
            return null;
        }
        return CollectionsKt.joinToString$default(cookies.entrySet(), "; ", null, null, 0, null, new Function1<Map.Entry<? extends String, ? extends String>, CharSequence>() { // from class: com.coldfriesinoctober.walrus.music.YtMusicApi$cookieHeader$1
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final CharSequence invoke2(Map.Entry<String, String> it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return ((Object) it.getKey()) + "=" + ((Object) it.getValue());
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ CharSequence invoke(Map.Entry<? extends String, ? extends String> entry) {
                return invoke2((Map.Entry<String, String>) entry);
            }
        }, 30, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ String cookieHeader$default(YtMusicApi ytMusicApi, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            map = sessionCookies;
        }
        return ytMusicApi.cookieHeader(map);
    }

    private final String directWatchVideoId(JsonObject renderer) {
        JsonObject obj;
        JsonObject obj2;
        JsonObject obj3;
        JsonObject obj4;
        JsonObject obj5;
        JsonObject obj6;
        String string;
        JsonObject obj7 = obj(renderer, "playlistItemData");
        if (obj7 != null && (string = string(obj7, YoutubeParsingHelper.VIDEO_ID)) != null) {
            return string;
        }
        JsonObject obj8 = obj(renderer, "navigationEndpoint");
        String string2 = (obj8 == null || (obj6 = obj(obj8, "watchEndpoint")) == null) ? null : string(obj6, YoutubeParsingHelper.VIDEO_ID);
        if (string2 != null) {
            return string2;
        }
        JsonObject obj9 = obj(renderer, "thumbnailOverlay");
        if (obj9 == null || (obj = obj(obj9, "musicItemThumbnailOverlayRenderer")) == null || (obj2 = obj(obj, "content")) == null || (obj3 = obj(obj2, "musicPlayButtonRenderer")) == null || (obj4 = obj(obj3, "playNavigationEndpoint")) == null || (obj5 = obj(obj4, "watchEndpoint")) == null) {
            return null;
        }
        return string(obj5, YoutubeParsingHelper.VIDEO_ID);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String extractHeaderArtwork(JsonObject root) {
        Object next;
        Integer intOrNull;
        Integer intOrNull2;
        String str;
        ArrayList arrayList = new ArrayList();
        Iterator it = CollectionsKt.listOf((Object[]) new String[]{"musicDetailHeaderRenderer", "musicImmersiveHeaderRenderer", "musicVisualHeaderRenderer", "musicEditablePlaylistDetailHeaderRenderer"}).iterator();
        while (it.hasNext()) {
            collectObjects(root, (String) it.next(), arrayList);
        }
        JsonObject jsonObject = (JsonObject) CollectionsKt.firstOrNull((List) arrayList);
        if (jsonObject == null) {
            return null;
        }
        ArrayList arrayList2 = new ArrayList();
        collectArrays(jsonObject, "thumbnails", arrayList2);
        List<JsonElement> flatten = CollectionsKt.flatten(arrayList2);
        ArrayList arrayList3 = new ArrayList();
        for (JsonElement jsonElement : flatten) {
            JsonObject jsonObject2 = jsonElement instanceof JsonObject ? (JsonObject) jsonElement : null;
            if (jsonObject2 != null) {
                arrayList3.add(jsonObject2);
            }
        }
        Iterator it2 = arrayList3.iterator();
        if (it2.hasNext()) {
            next = it2.next();
            if (it2.hasNext()) {
                String string = INSTANCE.string((JsonObject) next, "width");
                int intValue = (string == null || (intOrNull2 = StringsKt.toIntOrNull(string)) == null) ? 0 : intOrNull2.intValue();
                do {
                    Object next2 = it2.next();
                    String string2 = INSTANCE.string((JsonObject) next2, "width");
                    int intValue2 = (string2 == null || (intOrNull = StringsKt.toIntOrNull(string2)) == null) ? 0 : intOrNull.intValue();
                    if (intValue < intValue2) {
                        next = next2;
                        intValue = intValue2;
                    }
                } while (it2.hasNext());
            }
        } else {
            next = null;
        }
        JsonObject jsonObject3 = (JsonObject) next;
        if (jsonObject3 != null) {
            String string3 = string(jsonObject3, "url");
            if (string3 != null) {
                return INSTANCE.highResolutionArtwork(StringsKt.startsWith$default(string3, "//", false, 2, (Object) null) ? "https:" + string3 : string3);
            }
            str = null;
        } else {
            str = null;
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String extractHeaderText(JsonObject root, String key) {
        JsonObject obj;
        JsonArray array;
        String joinToString$default;
        String obj2;
        ArrayList arrayList = new ArrayList();
        Iterator it = CollectionsKt.listOf((Object[]) new String[]{"musicDetailHeaderRenderer", "musicImmersiveHeaderRenderer", "musicVisualHeaderRenderer", "musicEditablePlaylistDetailHeaderRenderer"}).iterator();
        while (it.hasNext()) {
            collectObjects(root, (String) it.next(), arrayList);
        }
        JsonObject jsonObject = (JsonObject) CollectionsKt.firstOrNull((List) arrayList);
        if (jsonObject == null || (obj = obj(jsonObject, "title")) == null || (array = array(obj, "runs")) == null || (joinToString$default = CollectionsKt.joinToString$default(array, "", null, null, 0, null, new Function1<JsonElement, CharSequence>() { // from class: com.coldfriesinoctober.walrus.music.YtMusicApi$extractHeaderText$1
            @Override // kotlin.jvm.functions.Function1
            public final CharSequence invoke(JsonElement it2) {
                JsonObject asObject;
                Intrinsics.checkNotNullParameter(it2, "it");
                asObject = YtMusicApi.INSTANCE.asObject(it2);
                String string = asObject != null ? YtMusicApi.INSTANCE.string(asObject, "text") : null;
                if (string == null) {
                    string = "";
                }
                return string;
            }
        }, 30, null)) == null || (obj2 = StringsKt.trim((CharSequence) joinToString$default).toString()) == null || !(true ^ StringsKt.isBlank(obj2))) {
            return null;
        }
        return obj2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object fetchAccountName$default(YtMusicApi ytMusicApi, Map map, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            map = null;
        }
        return ytMusicApi.fetchAccountName(map, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:11:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object fetchWebConfig(kotlin.coroutines.Continuation<? super com.coldfriesinoctober.walrus.music.YtMusicApi.WebConfig> r8) {
        /*
            r7 = this;
            boolean r0 = r8 instanceof com.coldfriesinoctober.walrus.music.YtMusicApi$fetchWebConfig$1
            if (r0 == 0) goto L14
            r0 = r8
            com.coldfriesinoctober.walrus.music.YtMusicApi$fetchWebConfig$1 r0 = (com.coldfriesinoctober.walrus.music.YtMusicApi$fetchWebConfig$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L19
        L14:
            com.coldfriesinoctober.walrus.music.YtMusicApi$fetchWebConfig$1 r0 = new com.coldfriesinoctober.walrus.music.YtMusicApi$fetchWebConfig$1
            r0.<init>(r7, r8)
        L19:
            r8 = r0
            java.lang.Object r0 = r8.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r8.label
            r3 = 1
            switch(r2) {
                case 0: goto L37;
                case 1: goto L2e;
                default: goto L26;
            }
        L26:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L2e:
            java.lang.Object r1 = r8.L$0
            com.coldfriesinoctober.walrus.music.YtMusicApi r1 = (com.coldfriesinoctober.walrus.music.YtMusicApi) r1
            kotlin.ResultKt.throwOnFailure(r0)
            r4 = r0
            goto L65
        L37:
            kotlin.ResultKt.throwOnFailure(r0)
            r2 = r7
            okhttp3.Request$Builder r4 = new okhttp3.Request$Builder
            r4.<init>()
            java.lang.String r5 = "https://music.youtube.com/"
            okhttp3.Request$Builder r4 = r4.url(r5)
            java.lang.String r5 = "User-Agent"
            java.lang.String r6 = "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:140.0) Gecko/20100101 Firefox/140.0"
            okhttp3.Request$Builder r4 = r4.header(r5, r6)
            okhttp3.Request r4 = r4.build()
            okhttp3.OkHttpClient r5 = com.coldfriesinoctober.walrus.music.YtMusicApi.http
            okhttp3.Call r5 = r5.newCall(r4)
            r8.L$0 = r2
            r8.label = r3
            java.lang.Object r4 = r2.awaitBody(r5, r8)
            if (r4 != r1) goto L64
            return r1
        L64:
            r1 = r2
        L65:
            kotlin.Pair r4 = (kotlin.Pair) r4
            java.lang.Object r2 = r4.component1()
            java.lang.Number r2 = (java.lang.Number) r2
            int r2 = r2.intValue()
            java.lang.Object r4 = r4.component2()
            java.lang.String r4 = (java.lang.String) r4
            r5 = 200(0xc8, float:2.8E-43)
            r6 = 0
            if (r5 > r2) goto L81
            r5 = 300(0x12c, float:4.2E-43)
            if (r2 >= r5) goto L81
            goto L82
        L81:
            r3 = r6
        L82:
            if (r3 == 0) goto La4
            com.coldfriesinoctober.walrus.music.YtMusicApi$WebConfig r2 = new com.coldfriesinoctober.walrus.music.YtMusicApi$WebConfig
            java.lang.String r3 = "INNERTUBE_API_KEY"
            java.lang.String r3 = r1.findConfig(r4, r3)
            if (r3 != 0) goto L90
            java.lang.String r3 = "AIzaSyC9XL3ZjWddXya6X74dJoCTL-WEYFDNX30"
        L90:
            java.lang.String r5 = "INNERTUBE_CONTEXT_CLIENT_VERSION"
            java.lang.String r5 = r1.findConfig(r4, r5)
            if (r5 != 0) goto L9a
            java.lang.String r5 = "1.20260707.12.00"
        L9a:
            java.lang.String r6 = "VISITOR_DATA"
            java.lang.String r6 = r1.findConfig(r4, r6)
            r2.<init>(r3, r5, r6)
            return r2
        La4:
            java.io.IOException r3 = new java.io.IOException
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "YTM config HTTP "
            java.lang.StringBuilder r5 = r5.append(r6)
            java.lang.StringBuilder r5 = r5.append(r2)
            java.lang.String r5 = r5.toString()
            r3.<init>(r5)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coldfriesinoctober.walrus.music.YtMusicApi.fetchWebConfig(kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final String findConfig(String html, String key) {
        List<String> groupValues;
        String str;
        String replace$default;
        String replace$default2;
        MatchResult find$default = Regex.find$default(new Regex("\\\"" + key + "\\\"\\s*:\\s*\\\"([^\\\"]+)\\\""), html, 0, 2, null);
        if (find$default == null || (groupValues = find$default.getGroupValues()) == null || (str = (String) CollectionsKt.getOrNull(groupValues, 1)) == null || (replace$default = StringsKt.replace$default(str, "\\u003d", "=", false, 4, (Object) null)) == null || (replace$default2 = StringsKt.replace$default(replace$default, "\\x3d", "=", false, 4, (Object) null)) == null) {
            return null;
        }
        return StringsKt.replace$default(replace$default2, "\\/", "/", false, 4, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final String findString(JsonElement element, String key) {
        String contentOrNull;
        if (!(element instanceof JsonObject)) {
            if (!(element instanceof JsonArray)) {
                return null;
            }
            Iterator it = ((Iterable) element).iterator();
            while (it.hasNext()) {
                String findString = INSTANCE.findString((JsonElement) it.next(), key);
                if (findString != null) {
                    return findString;
                }
            }
            return null;
        }
        Object obj = ((JsonObject) element).get((Object) key);
        JsonPrimitive jsonPrimitive = obj instanceof JsonPrimitive ? (JsonPrimitive) obj : null;
        if (jsonPrimitive != null && (contentOrNull = JsonElementKt.getContentOrNull(jsonPrimitive)) != null) {
            return contentOrNull;
        }
        Iterator<T> it2 = ((JsonObject) element).values().iterator();
        while (it2.hasNext()) {
            String findString2 = INSTANCE.findString((JsonElement) it2.next(), key);
            if (findString2 != null) {
                return findString2;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String headerSubtitle(JsonObject root) {
        ArrayList arrayList;
        String joinToString$default;
        JsonArray array;
        ArrayList arrayList2 = new ArrayList();
        Iterator it = CollectionsKt.listOf((Object[]) new String[]{"musicDetailHeaderRenderer", "musicImmersiveHeaderRenderer", "musicVisualHeaderRenderer", "musicEditablePlaylistDetailHeaderRenderer"}).iterator();
        while (it.hasNext()) {
            collectObjects(root, (String) it.next(), arrayList2);
        }
        JsonObject jsonObject = (JsonObject) CollectionsKt.firstOrNull((List) arrayList2);
        if (jsonObject == null) {
            return null;
        }
        JsonObject obj = obj(jsonObject, "subtitle");
        if (obj == null || (array = array(obj, "runs")) == null) {
            arrayList = null;
        } else {
            ArrayList arrayList3 = new ArrayList();
            Iterator<JsonElement> it2 = array.iterator();
            while (it2.hasNext()) {
                JsonObject asObject = INSTANCE.asObject(it2.next());
                String string = asObject != null ? INSTANCE.string(asObject, "text") : null;
                if (string != null) {
                    arrayList3.add(string);
                }
            }
            ArrayList arrayList4 = new ArrayList();
            for (Object obj2 : arrayList3) {
                String str = (String) obj2;
                if ((!(StringsKt.isBlank(str) ^ true) || Intrinsics.areEqual(str, "•") || Intrinsics.areEqual(str, "·")) ? false : true) {
                    arrayList4.add(obj2);
                }
            }
            arrayList = arrayList4;
        }
        ArrayList arrayList5 = arrayList;
        if (arrayList5 == null || (joinToString$default = CollectionsKt.joinToString$default(arrayList5, " · ", null, null, 0, null, null, 62, null)) == null || !(true ^ StringsKt.isBlank(joinToString$default))) {
            return null;
        }
        return joinToString$default;
    }

    private final String highResolutionArtwork(String str) {
        String str2 = StringsKt.startsWith$default(str, "//", false, 2, (Object) null) ? "https:" + str : str;
        if ((StringsKt.contains$default((CharSequence) str2, (CharSequence) "googleusercontent.com", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) str2, (CharSequence) "ggpht.com", false, 2, (Object) null)) && StringsKt.contains$default((CharSequence) str2, '=', false, 2, (Object) null)) {
            return StringsKt.substringBeforeLast$default(str2, '=', (String) null, 2, (Object) null) + "=w512-h512-l90-rj";
        }
        return str2;
    }

    public static /* synthetic */ Object homeSongs$default(YtMusicApi ytMusicApi, int i, Continuation continuation, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 20;
        }
        return ytMusicApi.homeSongs(i, continuation);
    }

    public static /* synthetic */ Object homeSongsMerged$default(YtMusicApi ytMusicApi, int i, Continuation continuation, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 24;
        }
        return ytMusicApi.homeSongsMerged(i, continuation);
    }

    /* renamed from: int, reason: not valid java name */
    private final Integer m6257int(JsonObject jsonObject, String str) {
        String string = string(jsonObject, str);
        if (string != null) {
            return StringsKt.toIntOrNull(string);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<YtTrack> interleave(List<YtTrack> a, List<YtTrack> b) {
        if (a.isEmpty()) {
            return b;
        }
        if (b.isEmpty()) {
            return a;
        }
        ArrayList arrayList = new ArrayList(a.size() + b.size());
        int max = Math.max(a.size(), b.size());
        for (int i = 0; i < max; i++) {
            if (i < a.size()) {
                arrayList.add(a.get(i));
            }
            if (i < b.size()) {
                arrayList.add(b.get(i));
            }
        }
        return arrayList;
    }

    private final boolean isLikelyArtistDetail(String str) {
        String obj = StringsKt.trim((CharSequence) str).toString();
        return (StringsKt.isBlank(obj) || SetsKt.setOf((Object[]) new String[]{"•", "·", "Song", "Video"}).contains(obj) || StringsKt.equals(obj, "Album", true) || StringsKt.equals(obj, "Single", true) || StringsKt.equals(obj, "EP", true) || StringsKt.equals(obj, "Playlist", true) || parseDuration(obj) != null || new Regex("^(19|20)\\d{2}$").matches(obj) || StringsKt.contains((CharSequence) obj, (CharSequence) " view", true) || StringsKt.contains((CharSequence) obj, (CharSequence) " song", true)) ? false : true;
    }

    public static /* synthetic */ Object likedSongs$default(YtMusicApi ytMusicApi, int i, Continuation continuation, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 100;
        }
        return ytMusicApi.likedSongs(i, continuation);
    }

    public static /* synthetic */ Object likedSongsByAccount$default(YtMusicApi ytMusicApi, int i, Continuation continuation, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 100;
        }
        return ytMusicApi.likedSongsByAccount(i, continuation);
    }

    public static /* synthetic */ Object likedSongsMerged$default(YtMusicApi ytMusicApi, int i, Continuation continuation, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 100;
        }
        return ytMusicApi.likedSongsMerged(i, continuation);
    }

    private final JsonObject obj(JsonElement jsonElement, String str) {
        JsonObject jsonObject = jsonElement instanceof JsonObject ? (JsonObject) jsonElement : null;
        if (jsonObject != null) {
            return obj(jsonObject, str);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final JsonObject obj(JsonObject jsonObject, String str) {
        Object obj = jsonObject.get((Object) str);
        if (obj instanceof JsonObject) {
            return (JsonObject) obj;
        }
        return null;
    }

    private final Map<String, String> parseCookies(String cookieHeader) {
        List list;
        Pair pair;
        int i = 0;
        List<String> split$default = StringsKt.split$default((CharSequence) cookieHeader, new char[]{';'}, false, 0, 6, (Object) null);
        ArrayList arrayList = new ArrayList();
        for (String str : split$default) {
            int indexOf$default = StringsKt.indexOf$default((CharSequence) str, '=', 0, false, 6, (Object) null);
            if (indexOf$default <= 0) {
                pair = null;
                list = split$default;
            } else {
                String substring = str.substring(i, indexOf$default);
                Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
                String obj = StringsKt.trim((CharSequence) substring).toString();
                list = split$default;
                String substring2 = str.substring(indexOf$default + 1);
                Intrinsics.checkNotNullExpressionValue(substring2, "substring(...)");
                pair = TuplesKt.to(obj, StringsKt.trim((CharSequence) substring2).toString());
            }
            if (pair != null) {
                arrayList.add(pair);
            }
            split$default = list;
            i = 0;
        }
        return MapsKt.toMap(arrayList);
    }

    private final Integer parseDuration(String value) {
        List split$default = StringsKt.split$default((CharSequence) StringsKt.trim((CharSequence) value).toString(), new char[]{AbstractJsonLexerKt.COLON}, false, 0, 6, (Object) null);
        ArrayList arrayList = new ArrayList();
        Iterator it = split$default.iterator();
        while (it.hasNext()) {
            Integer intOrNull = StringsKt.toIntOrNull((String) it.next());
            if (intOrNull != null) {
                arrayList.add(intOrNull);
            }
        }
        ArrayList arrayList2 = arrayList;
        int size = arrayList2.size();
        if (!(2 <= size && size < 4)) {
            return null;
        }
        Integer num = 0;
        Iterator it2 = arrayList2.iterator();
        while (it2.hasNext()) {
            num = Integer.valueOf((num.intValue() * 60) + ((Number) it2.next()).intValue());
        }
        return num;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:86:0x01d2  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x01d5 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.coldfriesinoctober.walrus.music.YtEntity parseEntity(kotlinx.serialization.json.JsonObject r34, com.coldfriesinoctober.walrus.music.YtEntityKind r35) {
        /*
            Method dump skipped, instructions count: 651
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coldfriesinoctober.walrus.music.YtMusicApi.parseEntity(kotlinx.serialization.json.JsonObject, com.coldfriesinoctober.walrus.music.YtEntityKind):com.coldfriesinoctober.walrus.music.YtEntity");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<YtTrack> parseHomeFeedSongs(JsonElement root) {
        ArrayList arrayList = new ArrayList();
        collectObjects(root, "musicResponsiveListItemRenderer", arrayList);
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            if (INSTANCE.directWatchVideoId((JsonObject) obj) != null) {
                arrayList2.add(obj);
            }
        }
        ArrayList arrayList3 = arrayList2;
        ArrayList arrayList4 = new ArrayList();
        Iterator it = arrayList3.iterator();
        while (it.hasNext()) {
            YtTrack parseSong = parseSong((JsonObject) it.next());
            if (parseSong != null) {
                arrayList4.add(parseSong);
            }
        }
        List mutableList = CollectionsKt.toMutableList((Collection) arrayList4);
        ArrayList arrayList5 = new ArrayList();
        collectObjects(root, "musicTwoRowItemRenderer", arrayList5);
        List list = mutableList;
        ArrayList arrayList6 = new ArrayList();
        Iterator it2 = arrayList5.iterator();
        while (it2.hasNext()) {
            YtTrack parseTwoRowSong = parseTwoRowSong((JsonObject) it2.next());
            if (parseTwoRowSong != null) {
                arrayList6.add(parseTwoRowSong);
            }
        }
        CollectionsKt.addAll(list, arrayList6);
        HashSet hashSet = new HashSet();
        ArrayList arrayList7 = new ArrayList();
        for (Object obj2 : mutableList) {
            if (hashSet.add(((YtTrack) obj2).getVideoId())) {
                arrayList7.add(obj2);
            }
        }
        return arrayList7;
    }

    /* JADX WARN: Removed duplicated region for block: B:59:0x0124 A[LOOP:1: B:47:0x00df->B:59:0x0124, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x012c A[EDGE_INSN: B:60:0x012c->B:61:0x012c BREAK  A[LOOP:1: B:47:0x00df->B:59:0x0124], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final com.coldfriesinoctober.walrus.music.YtTrack parsePanelSong(kotlinx.serialization.json.JsonObject r25) {
        /*
            Method dump skipped, instructions count: 648
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coldfriesinoctober.walrus.music.YtMusicApi.parsePanelSong(kotlinx.serialization.json.JsonObject):com.coldfriesinoctober.walrus.music.YtTrack");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:111:0x037c  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x038a  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x02ef  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x039a  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x039f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x01dd A[LOOP:1: B:44:0x0193->B:56:0x01dd, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x01e7 A[EDGE_INSN: B:57:0x01e7->B:58:0x01e7 BREAK  A[LOOP:1: B:44:0x0193->B:56:0x01dd], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x022b  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x02dc A[LOOP:3: B:78:0x028c->B:86:0x02dc, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x02d9 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:92:0x02fe  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x031e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.List<com.coldfriesinoctober.walrus.music.YtPlaylistSummary> parsePlaylistRenderers(kotlinx.serialization.json.JsonElement r41) {
        /*
            Method dump skipped, instructions count: 1019
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coldfriesinoctober.walrus.music.YtMusicApi.parsePlaylistRenderers(kotlinx.serialization.json.JsonElement):java.util.List");
    }

    private final YtTrack parsePlaylistVideo(JsonObject renderer) {
        String str;
        JsonArray array;
        JsonElement jsonElement;
        JsonObject asObject;
        String string;
        JsonArray array2;
        JsonElement jsonElement2;
        JsonObject asObject2;
        String string2;
        JsonArray array3;
        String string3 = string(renderer, YoutubeParsingHelper.VIDEO_ID);
        if (string3 == null) {
            return null;
        }
        JsonObject obj = obj(renderer, "title");
        if (obj == null || (array3 = array(obj, "runs")) == null || (str = CollectionsKt.joinToString$default(array3, "", null, null, 0, null, new Function1<JsonElement, CharSequence>() { // from class: com.coldfriesinoctober.walrus.music.YtMusicApi$parsePlaylistVideo$title$1
            @Override // kotlin.jvm.functions.Function1
            public final CharSequence invoke(JsonElement it) {
                JsonObject asObject3;
                Intrinsics.checkNotNullParameter(it, "it");
                asObject3 = YtMusicApi.INSTANCE.asObject(it);
                String string4 = asObject3 != null ? YtMusicApi.INSTANCE.string(asObject3, "text") : null;
                if (string4 == null) {
                    string4 = "";
                }
                return string4;
            }
        }, 30, null)) == null) {
            JsonObject obj2 = obj(renderer, "title");
            String string4 = obj2 != null ? string(obj2, "simpleText") : null;
            if (string4 == null) {
                return null;
            }
            str = string4;
        }
        JsonObject obj3 = obj(renderer, "shortBylineText");
        String str2 = (obj3 == null || (array2 = array(obj3, "runs")) == null || (jsonElement2 = (JsonElement) CollectionsKt.firstOrNull((List) array2)) == null || (asObject2 = asObject(jsonElement2)) == null || (string2 = string(asObject2, "text")) == null) ? "Unknown artist" : string2;
        String string5 = string(renderer, "lengthSeconds");
        Integer intOrNull = string5 != null ? StringsKt.toIntOrNull(string5) : null;
        JsonObject obj4 = obj(renderer, "thumbnail");
        return new YtTrack(string3, str, str2, null, (obj4 == null || (array = array(obj4, "thumbnails")) == null || (jsonElement = (JsonElement) CollectionsKt.lastOrNull((List) array)) == null || (asObject = asObject(jsonElement)) == null || (string = string(asObject, "url")) == null) ? null : highResolutionArtwork(string), intOrNull);
    }

    /* JADX WARN: Removed duplicated region for block: B:65:0x0157 A[LOOP:1: B:53:0x00ff->B:65:0x0157, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0169 A[EDGE_INSN: B:66:0x0169->B:67:0x0169 BREAK  A[LOOP:1: B:53:0x00ff->B:65:0x0157], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x024d A[LOOP:2: B:73:0x01f9->B:85:0x024d, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x025a A[EDGE_INSN: B:86:0x025a->B:87:0x025a BREAK  A[LOOP:2: B:73:0x01f9->B:85:0x024d], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final com.coldfriesinoctober.walrus.music.YtTrack parseSong(kotlinx.serialization.json.JsonObject r29) {
        /*
            Method dump skipped, instructions count: 832
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coldfriesinoctober.walrus.music.YtMusicApi.parseSong(kotlinx.serialization.json.JsonObject):com.coldfriesinoctober.walrus.music.YtTrack");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<YtTrack> parseSongRenderers(JsonElement root) {
        ArrayList arrayList = new ArrayList();
        collectObjects(root, "musicResponsiveListItemRenderer", arrayList);
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            YtTrack parseSong = parseSong((JsonObject) it.next());
            if (parseSong != null) {
                arrayList2.add(parseSong);
            }
        }
        List mutableList = CollectionsKt.toMutableList((Collection) arrayList2);
        ArrayList arrayList3 = new ArrayList();
        collectObjects(root, "playlistPanelVideoRenderer", arrayList3);
        List list = mutableList;
        ArrayList arrayList4 = new ArrayList();
        Iterator it2 = arrayList3.iterator();
        while (it2.hasNext()) {
            ArrayList arrayList5 = arrayList;
            YtTrack parsePanelSong = parsePanelSong((JsonObject) it2.next());
            if (parsePanelSong != null) {
                arrayList4.add(parsePanelSong);
            }
            arrayList = arrayList5;
        }
        CollectionsKt.addAll(list, arrayList4);
        if (mutableList.isEmpty()) {
            ArrayList arrayList6 = new ArrayList();
            collectObjects(root, "playlistVideoRenderer", arrayList6);
            List list2 = mutableList;
            ArrayList arrayList7 = new ArrayList();
            Iterator it3 = arrayList6.iterator();
            while (it3.hasNext()) {
                YtTrack parsePlaylistVideo = parsePlaylistVideo((JsonObject) it3.next());
                if (parsePlaylistVideo != null) {
                    arrayList7.add(parsePlaylistVideo);
                }
            }
            CollectionsKt.addAll(list2, arrayList7);
        }
        HashSet hashSet = new HashSet();
        ArrayList arrayList8 = new ArrayList();
        for (Object obj : mutableList) {
            if (hashSet.add(((YtTrack) obj).getVideoId())) {
                arrayList8.add(obj);
            }
        }
        return arrayList8;
    }

    /* JADX WARN: Removed duplicated region for block: B:114:0x0267  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x023d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:126:0x018a  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x01c2  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x01d9  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x01d4 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:148:0x015c A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0157 A[LOOP:1: B:49:0x0112->B:61:0x0157, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0161 A[EDGE_INSN: B:62:0x0161->B:63:0x0161 BREAK  A[LOOP:1: B:49:0x0112->B:61:0x0157], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x01f6  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x022e  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x024c  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x027c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final com.coldfriesinoctober.walrus.music.YtTrack parseTwoRowSong(kotlinx.serialization.json.JsonObject r25) {
        /*
            Method dump skipped, instructions count: 717
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coldfriesinoctober.walrus.music.YtMusicApi.parseTwoRowSong(kotlinx.serialization.json.JsonObject):com.coldfriesinoctober.walrus.music.YtTrack");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Failed to find 'out' block for switch in B:7:0x002a. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0171  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0192 A[Catch: Exception -> 0x01a1, TRY_LEAVE, TryCatch #3 {Exception -> 0x01a1, blocks: (B:32:0x0179, B:33:0x0191, B:35:0x0177, B:36:0x0192), top: B:28:0x016f }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x01be  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x01e9  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x01f2  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002d  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:45:0x01e2 -> B:12:0x01e5). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:46:0x01e9 -> B:13:0x01ec). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object post(java.lang.String r19, kotlinx.serialization.json.JsonObject r20, java.lang.String r21, java.lang.String r22, java.lang.String r23, java.lang.String r24, java.lang.String r25, java.lang.String r26, int r27, boolean r28, java.util.Map<java.lang.String, java.lang.String> r29, kotlin.coroutines.Continuation<? super kotlinx.serialization.json.JsonObject> r30) {
        /*
            Method dump skipped, instructions count: 554
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coldfriesinoctober.walrus.music.YtMusicApi.post(java.lang.String, kotlinx.serialization.json.JsonObject, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, boolean, java.util.Map, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Object post$default(YtMusicApi ytMusicApi, String str, JsonObject jsonObject, String str2, String str3, String str4, String str5, String str6, String str7, int i, boolean z, Map map, Continuation continuation, int i2, Object obj) {
        return ytMusicApi.post(str, jsonObject, str2, str3, str4, (i2 & 32) != 0 ? YOUTUBE_MUSIC_ORIGIN : str5, (i2 & 64) != 0 ? "https://music.youtube.com/" : str6, (i2 & 128) != 0 ? null : str7, (i2 & 256) != 0 ? 2 : i, (i2 & 512) != 0 ? false : z, (i2 & 1024) != 0 ? null : map, continuation);
    }

    public static /* synthetic */ void prefetchAll$default(YtMusicApi ytMusicApi, List list, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 3;
        }
        ytMusicApi.prefetchAll(list, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00d2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean probeStream(com.coldfriesinoctober.walrus.music.YtStream r13) {
        /*
            r12 = this;
            r0 = 0
            kotlin.Result$Companion r1 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> Lbd
            r1 = r12
            com.coldfriesinoctober.walrus.music.YtMusicApi r1 = (com.coldfriesinoctober.walrus.music.YtMusicApi) r1     // Catch: java.lang.Throwable -> Lbd
            r2 = 0
            okhttp3.Request$Builder r3 = new okhttp3.Request$Builder     // Catch: java.lang.Throwable -> Lbd
            r3.<init>()     // Catch: java.lang.Throwable -> Lbd
            java.lang.String r4 = r13.getUrl()     // Catch: java.lang.Throwable -> Lbd
            okhttp3.Request$Builder r3 = r3.url(r4)     // Catch: java.lang.Throwable -> Lbd
            java.lang.String r4 = "Accept-Encoding"
            java.lang.String r5 = "identity"
            okhttp3.Request$Builder r3 = r3.header(r4, r5)     // Catch: java.lang.Throwable -> Lbd
            java.lang.String r4 = "Range"
            java.lang.String r5 = "bytes=0-1"
            okhttp3.Request$Builder r3 = r3.header(r4, r5)     // Catch: java.lang.Throwable -> Lbd
            java.util.Map r4 = r13.getHeaders()     // Catch: java.lang.Throwable -> Lbd
            r5 = 0
            java.util.Set r6 = r4.entrySet()     // Catch: java.lang.Throwable -> Lbd
            java.util.Iterator r6 = r6.iterator()     // Catch: java.lang.Throwable -> Lbd
        L32:
            boolean r7 = r6.hasNext()     // Catch: java.lang.Throwable -> Lbd
            if (r7 == 0) goto L50
            java.lang.Object r7 = r6.next()     // Catch: java.lang.Throwable -> Lbd
            java.util.Map$Entry r7 = (java.util.Map.Entry) r7     // Catch: java.lang.Throwable -> Lbd
            r8 = 0
            java.lang.Object r9 = r7.getKey()     // Catch: java.lang.Throwable -> Lbd
            java.lang.String r9 = (java.lang.String) r9     // Catch: java.lang.Throwable -> Lbd
            java.lang.Object r10 = r7.getValue()     // Catch: java.lang.Throwable -> Lbd
            java.lang.String r10 = (java.lang.String) r10     // Catch: java.lang.Throwable -> Lbd
            r3.header(r9, r10)     // Catch: java.lang.Throwable -> Lbd
            goto L32
        L50:
            okhttp3.OkHttpClient r4 = com.coldfriesinoctober.walrus.music.YtMusicApi.http     // Catch: java.lang.Throwable -> Lbd
            okhttp3.Request r5 = r3.build()     // Catch: java.lang.Throwable -> Lbd
            okhttp3.Call r4 = r4.newCall(r5)     // Catch: java.lang.Throwable -> Lbd
            okhttp3.Response r4 = r4.execute()     // Catch: java.lang.Throwable -> Lbd
            java.io.Closeable r4 = (java.io.Closeable) r4     // Catch: java.lang.Throwable -> Lbd
            r5 = r4
            okhttp3.Response r5 = (okhttp3.Response) r5     // Catch: java.lang.Throwable -> Lb6
            r6 = 0
            java.lang.String r7 = "Content-Type"
            r8 = 2
            r9 = 0
            java.lang.String r7 = okhttp3.Response.header$default(r5, r7, r9, r8, r9)     // Catch: java.lang.Throwable -> Lb6
            if (r7 != 0) goto L71
            java.lang.String r7 = ""
        L71:
            java.util.Locale r10 = java.util.Locale.ROOT     // Catch: java.lang.Throwable -> Lb6
            java.lang.String r7 = r7.toLowerCase(r10)     // Catch: java.lang.Throwable -> Lb6
            java.lang.String r10 = "toLowerCase(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r10)     // Catch: java.lang.Throwable -> Lb6
            int r10 = r5.code()     // Catch: java.lang.Throwable -> Lb6
            r11 = 200(0xc8, float:2.8E-43)
            if (r10 == r11) goto L8c
            int r10 = r5.code()     // Catch: java.lang.Throwable -> Lb6
            r11 = 206(0xce, float:2.89E-43)
            if (r10 != r11) goto La8
        L8c:
            r10 = r7
            java.lang.CharSequence r10 = (java.lang.CharSequence) r10     // Catch: java.lang.Throwable -> Lb6
            java.lang.String r11 = "text/html"
            java.lang.CharSequence r11 = (java.lang.CharSequence) r11     // Catch: java.lang.Throwable -> Lb6
            boolean r10 = kotlin.text.StringsKt.contains$default(r10, r11, r0, r8, r9)     // Catch: java.lang.Throwable -> Lb6
            if (r10 != 0) goto La8
            r10 = r7
            java.lang.CharSequence r10 = (java.lang.CharSequence) r10     // Catch: java.lang.Throwable -> Lb6
            java.lang.String r11 = "application/json"
            java.lang.CharSequence r11 = (java.lang.CharSequence) r11     // Catch: java.lang.Throwable -> Lb6
            boolean r8 = kotlin.text.StringsKt.contains$default(r10, r11, r0, r8, r9)     // Catch: java.lang.Throwable -> Lb6
            if (r8 != 0) goto La8
            r8 = 1
            goto La9
        La8:
            r8 = r0
        La9:
            kotlin.io.CloseableKt.closeFinally(r4, r9)     // Catch: java.lang.Throwable -> Lbd
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r8)     // Catch: java.lang.Throwable -> Lbd
            java.lang.Object r1 = kotlin.Result.m6535constructorimpl(r1)     // Catch: java.lang.Throwable -> Lbd
            goto Lc8
        Lb6:
            r5 = move-exception
            throw r5     // Catch: java.lang.Throwable -> Lb8
        Lb8:
            r6 = move-exception
            kotlin.io.CloseableKt.closeFinally(r4, r5)     // Catch: java.lang.Throwable -> Lbd
            throw r6     // Catch: java.lang.Throwable -> Lbd
        Lbd:
            r1 = move-exception
            kotlin.Result$Companion r2 = kotlin.Result.INSTANCE
            java.lang.Object r1 = kotlin.ResultKt.createFailure(r1)
            java.lang.Object r1 = kotlin.Result.m6535constructorimpl(r1)
        Lc8:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            boolean r2 = kotlin.Result.m6541isFailureimpl(r1)
            if (r2 == 0) goto Ld3
            r1 = r0
        Ld3:
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r0 = r1.booleanValue()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coldfriesinoctober.walrus.music.YtMusicApi.probeStream(com.coldfriesinoctober.walrus.music.YtStream):boolean");
    }

    public static /* synthetic */ Object rateSong$default(YtMusicApi ytMusicApi, String str, boolean z, int i, Continuation continuation, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = 1;
        }
        return ytMusicApi.rateSong(str, z, i, continuation);
    }

    public static /* synthetic */ Object related$default(YtMusicApi ytMusicApi, String str, int i, Continuation continuation, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 25;
        }
        return ytMusicApi.related(str, i, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final YtStream resolveViaYtDlp(String videoId) {
        WalrusApp companion = WalrusApp.INSTANCE.getInstance();
        YoutubeDL youtubeDL = YoutubeDL.getInstance();
        try {
            Result.Companion companion2 = Result.INSTANCE;
            YtMusicApi ytMusicApi = this;
            youtubeDL.init(companion);
            Result.m6535constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion3 = Result.INSTANCE;
            Result.m6535constructorimpl(ResultKt.createFailure(th));
        }
        YoutubeDLRequest youtubeDLRequest = new YoutubeDLRequest("https://music.youtube.com/watch?v=" + videoId);
        youtubeDLRequest.addOption("--no-playlist");
        youtubeDLRequest.addOption("-f", "bestaudio[ext=m4a]/bestaudio/best");
        youtubeDLRequest.addOption("-g");
        Object obj = null;
        for (Object obj2 : SequencesKt.map(StringsKt.lineSequence(YoutubeDL.execute$default(youtubeDL, youtubeDLRequest, null, null, 6, null).getOut()), new Function1<String, String>() { // from class: com.coldfriesinoctober.walrus.music.YtMusicApi$resolveViaYtDlp$url$1
            @Override // kotlin.jvm.functions.Function1
            public final String invoke(String it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return StringsKt.trim((CharSequence) it).toString();
            }
        })) {
            if (StringsKt.startsWith$default((String) obj2, "http", false, 2, (Object) null)) {
                obj = obj2;
            }
        }
        String str = (String) obj;
        if (str != null) {
            return new YtStream(str, null, 0, MapsKt.emptyMap());
        }
        throw new IOException("yt-dlp returned no stream url");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Failed to find 'out' block for switch in B:7:0x0029. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x01d0  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x01e0 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x01e1  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x01d7  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002c  */
    /* JADX WARN: Type inference failed for: r15v6, types: [com.coldfriesinoctober.walrus.music.YtStream] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object resolveWithClient(java.lang.String r26, com.coldfriesinoctober.walrus.music.YtMusicApi.PlayerClient r27, java.lang.String r28, boolean r29, kotlin.coroutines.Continuation<? super com.coldfriesinoctober.walrus.music.YtStream> r30) {
        /*
            Method dump skipped, instructions count: 872
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coldfriesinoctober.walrus.music.YtMusicApi.resolveWithClient(java.lang.String, com.coldfriesinoctober.walrus.music.YtMusicApi$PlayerClient, java.lang.String, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final String sapisid(Map<String, String> cookies) {
        String str = cookies.get("__Secure-3PAPISID");
        if (str != null) {
            return str;
        }
        String str2 = cookies.get("SAPISID");
        return str2 == null ? cookies.get("APISID") : str2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ String sapisid$default(YtMusicApi ytMusicApi, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            map = sessionCookies;
        }
        return ytMusicApi.sapisid(map);
    }

    private final String sapisidHash(Map<String, String> cookies, String origin) {
        String sapisid = sapisid(cookies);
        if (sapisid == null) {
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
        byte[] bytes = (currentTimeMillis + Stream.ID_UNKNOWN + sapisid + Stream.ID_UNKNOWN + origin).getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        byte[] digest = messageDigest.digest(bytes);
        Intrinsics.checkNotNull(digest);
        return "SAPISIDHASH " + currentTimeMillis + "_" + ArraysKt.joinToString$default(digest, (CharSequence) "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) new Function1<Byte, CharSequence>() { // from class: com.coldfriesinoctober.walrus.music.YtMusicApi$sapisidHash$hex$1
            public final CharSequence invoke(byte b) {
                String format = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(b)}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "format(...)");
                return format;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ CharSequence invoke(Byte b) {
                return invoke(b.byteValue());
            }
        }, 30, (Object) null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ String sapisidHash$default(YtMusicApi ytMusicApi, Map map, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            map = sessionCookies;
        }
        if ((i & 2) != 0) {
            str = YOUTUBE_MUSIC_ORIGIN;
        }
        return ytMusicApi.sapisidHash(map, str);
    }

    public static /* synthetic */ Object searchAlbums$default(YtMusicApi ytMusicApi, String str, int i, Continuation continuation, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 20;
        }
        return ytMusicApi.searchAlbums(str, i, continuation);
    }

    public static /* synthetic */ Object searchArtists$default(YtMusicApi ytMusicApi, String str, int i, Continuation continuation, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 20;
        }
        return ytMusicApi.searchArtists(str, i, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object searchEntities(String str, YtEntityKind ytEntityKind, String str2, int i, Continuation<? super List<YtEntity>> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new YtMusicApi$searchEntities$2(str, i, str2, ytEntityKind, null), continuation);
    }

    public static /* synthetic */ Object searchPlaylists$default(YtMusicApi ytMusicApi, String str, int i, Continuation continuation, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 20;
        }
        return ytMusicApi.searchPlaylists(str, i, continuation);
    }

    public static /* synthetic */ Object searchTracks$default(YtMusicApi ytMusicApi, String str, int i, Continuation continuation, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 25;
        }
        return ytMusicApi.searchTracks(str, i, continuation);
    }

    private final String string(JsonElement jsonElement, String str) {
        JsonObject jsonObject = jsonElement instanceof JsonObject ? (JsonObject) jsonElement : null;
        if (jsonObject != null) {
            return string(jsonObject, str);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String string(JsonObject jsonObject, String str) {
        Object obj = jsonObject.get((Object) str);
        JsonPrimitive jsonPrimitive = obj instanceof JsonPrimitive ? (JsonPrimitive) obj : null;
        if (jsonPrimitive != null) {
            return JsonElementKt.getContentOrNull(jsonPrimitive);
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object trackListPage$default(YtMusicApi ytMusicApi, String str, int i, Map map, Continuation continuation, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 100;
        }
        if ((i2 & 4) != 0) {
            map = null;
        }
        return ytMusicApi.trackListPage(str, i, map, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Failed to find 'out' block for switch in B:7:0x002f. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:11:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0032  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object webConfig(kotlin.coroutines.Continuation<? super com.coldfriesinoctober.walrus.music.YtMusicApi.WebConfig> r21) {
        /*
            Method dump skipped, instructions count: 390
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coldfriesinoctober.walrus.music.YtMusicApi.webConfig(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Object charts(int i, Continuation<? super List<YtTrack>> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new YtMusicApi$charts$2(i, null), continuation);
    }

    public final void clearSession() {
        sessionCookies = MapsKt.emptyMap();
        accountName = null;
        accountAvatar = null;
    }

    public final void clearSession2() {
        sessionCookies2 = MapsKt.emptyMap();
        accountName2 = null;
        accountAvatar2 = null;
    }

    public final void clearStreamCache() {
        streamCache.clear();
    }

    public final Object fetchAccountName(Map<String, String> map, Continuation<? super String> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new YtMusicApi$fetchAccountName$2(map, null), continuation);
    }

    public final Object fetchAccountName2(Continuation<? super String> continuation) {
        return fetchAccountName(sessionCookies2, continuation);
    }

    public final String getAccountAvatar() {
        return accountAvatar;
    }

    public final String getAccountAvatar2() {
        return accountAvatar2;
    }

    public final int getAccountCount() {
        return (isLoggedIn() ? 1 : 0) + (isLoggedIn2() ? 1 : 0);
    }

    public final String getAccountName() {
        return accountName;
    }

    public final String getAccountName2() {
        return accountName2;
    }

    public final String getPrimarySapisid() {
        String str = sessionCookies.get("__Secure-3PAPISID");
        if (str != null) {
            return str;
        }
        String str2 = sessionCookies.get("SAPISID");
        return str2 == null ? sessionCookies.get("APISID") : str2;
    }

    public final Object homeSongs(int i, Continuation<? super List<YtTrack>> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new YtMusicApi$homeSongs$2(i, null), continuation);
    }

    public final Object homeSongsMerged(int i, Continuation<? super List<YtTrack>> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new YtMusicApi$homeSongsMerged$2(i, null), continuation);
    }

    public final void invalidateWebConfig() {
        webConfig = null;
        try {
            Result.Companion companion = Result.INSTANCE;
            YtMusicApi ytMusicApi = this;
            Prefs.INSTANCE.setBlocking(Prefs.INSTANCE.getYT_WEBCFG(), "");
            Result.m6535constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m6535constructorimpl(ResultKt.createFailure(th));
        }
    }

    public final boolean isLoggedIn() {
        return !sessionCookies.isEmpty();
    }

    public final boolean isLoggedIn2() {
        return !sessionCookies2.isEmpty();
    }

    public final Object likedSongs(int i, Continuation<? super YtPage> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new YtMusicApi$likedSongs$2(i, null), continuation);
    }

    public final Object likedSongsByAccount(int i, Continuation<? super Pair<? extends List<YtTrack>, ? extends List<YtTrack>>> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new YtMusicApi$likedSongsByAccount$2(i, null), continuation);
    }

    public final Object likedSongsMerged(int i, Continuation<? super List<YtTrack>> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new YtMusicApi$likedSongsMerged$2(i, null), continuation);
    }

    public final void prefetch(String videoId) {
        String str = videoId;
        if ((str == null || StringsKt.isBlank(str)) || streamCache.containsKey(videoId) || !prefetching.add(videoId)) {
            return;
        }
        BuildersKt__Builders_commonKt.launch$default(prefetchScope, null, null, new YtMusicApi$prefetch$1(videoId, null), 3, null);
    }

    public final void prefetchAll(List<String> videoIds, int max) {
        Intrinsics.checkNotNullParameter(videoIds, "videoIds");
        Iterator it = CollectionsKt.take(CollectionsKt.filterNotNull(videoIds), max).iterator();
        while (it.hasNext()) {
            prefetch((String) it.next());
        }
    }

    public final Object rateSong(String str, boolean z, int i, Continuation<? super Boolean> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new YtMusicApi$rateSong$2(i, z, str, null), continuation);
    }

    public final Object related(String str, int i, Continuation<? super List<YtTrack>> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new YtMusicApi$related$2(str, i, null), continuation);
    }

    public final Object resolveStream(String str, Continuation<? super YtStream> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new YtMusicApi$resolveStream$2(str, null), continuation);
    }

    public final Object resolveStreamFast(String str, Continuation<? super YtStream> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new YtMusicApi$resolveStreamFast$2(str, null), continuation);
    }

    public final String sapisidValue(String cookieHeader) {
        Intrinsics.checkNotNullParameter(cookieHeader, "cookieHeader");
        Map<String, String> parseCookies = parseCookies(cookieHeader);
        String str = parseCookies.get("__Secure-3PAPISID");
        if (str != null) {
            return str;
        }
        String str2 = parseCookies.get("SAPISID");
        return str2 == null ? parseCookies.get("APISID") : str2;
    }

    public final Object searchAlbums(String str, int i, Continuation<? super List<YtEntity>> continuation) {
        return searchEntities(str, YtEntityKind.ALBUM, "EgWKAQIYAWoKEAkQBRAKEAMQBA==", i, continuation);
    }

    public final Object searchArtists(String str, int i, Continuation<? super List<YtEntity>> continuation) {
        return searchEntities(str, YtEntityKind.ARTIST, "EgWKAQIgAWoKEAkQBRAKEAMQBA==", i, continuation);
    }

    public final Object searchPlaylists(String str, int i, Continuation<? super List<YtPlaylistSummary>> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new YtMusicApi$searchPlaylists$2(str, i, null), continuation);
    }

    public final Object searchTracks(String str, int i, Continuation<? super List<YtTrack>> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new YtMusicApi$searchTracks$2(str, i, null), continuation);
    }

    public final String sessionCookieHeader() {
        return cookieHeader(sessionCookies);
    }

    public final void setSession(String cookieHeader) {
        Intrinsics.checkNotNullParameter(cookieHeader, "cookieHeader");
        sessionCookies = parseCookies(cookieHeader);
    }

    public final void setSession2(String cookieHeader) {
        Intrinsics.checkNotNullParameter(cookieHeader, "cookieHeader");
        sessionCookies2 = parseCookies(cookieHeader);
    }

    public final Object trackListPage(String str, int i, Map<String, String> map, Continuation<? super YtPage> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new YtMusicApi$trackListPage$2(str, i, map, null), continuation);
    }

    public final Object warmStream(String str, Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(Dispatchers.getIO(), new YtMusicApi$warmStream$2(str, null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }

    public final void warmUp() {
        BuildersKt__Builders_commonKt.launch$default(prefetchScope, null, null, new YtMusicApi$warmUp$1(null), 3, null);
    }
}

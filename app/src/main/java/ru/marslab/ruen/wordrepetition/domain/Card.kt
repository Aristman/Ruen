package ru.marslab.ruen.wordrepetition.domain

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import ru.marslab.ruen.wordrepetition.utilities.DateProvider
import java.util.*

@Parcelize
data class Card(
    var id: Long? = null,
    var value: String,
    var imageUrl: String? = "https://yandex-images.clstorage.net/X96gcs385/ba0f83rHxJx/2U3_dILmcAtSljvEvWFLn4Qxt6976wP-4w-T6SBsDFLjI6ncWLBtifMafuUdx61bk0UTolLB2r2ALLSSKA-XtMmOuueU9aXah4fqGOu0TwxWJeAu-i1F_PReVeh1PAkUNjQnCYi0fp3mDqUkn0XqkFnN1D9JClZjyHD_lSlZlnSbiOgiDWwgT5YScRfy4Q2Gije2pv6jlvSkSEukIKSc1u_sbdCQtXJT4UKrck-cc1nfhhB6SECYaA37-JClV5pxGRcuJ8OjfUMRWvPZOqmNyMF4eiI_qZW24EsDbCponh5m7WKY0jM2lemE4jzOkvecnwsVds1J328AuPeT75PUPxidbu7Gr3RGERP3XTVmSgkDsPDlM--T-SxICa3qaxkeoCjv2Nf4PNwuS2CyStS31tOGUv4LxxOpCPawk-Nb0vkW1-QnieAzwtBS-tE7o8SAwrg1IDbt1XyuhArobaxdHydjpZ0SNHwcowsgMkrdup2QCRFxTkFcpcMxcdokkt41UZ7tLwrn9E_W0z1VPmxGRg-zemtx6Bi9oQgJ5K0iH5wjYGfb0nD_kSWF4jCCkPzSHQBWNYDDm-DAd7lerJNW_5AZKikJ4nSMHFa8l3-ijI1GvLIn9K8WOyPAiWIrqZXc4eMq2RH1M1vmgmD7S1gzVt9HmL7Dg9zoCveyEudZHrzXGmwkSWL6ShSecle2bcoAiLv0qnfv2b_gSAIlJGWf3SQgbN9aMfscLkok8Iaft9kcDxk-BQ_eoQM7ONmh2lc_lhXnqofvPYOXX_ue8uYGDg85ty-7bx347wZLZCms3hVuaWKfWbI9GWNHo_lDnTDe1kOfdM5CGGgIO_EV69hbdxDXLi8GqzVFW95_W__iQ4mCOXDnsaCVd-jGTCip65UYoSlqWxC6MBVnBuP-itN61dXBXDrIhZKnwjl-V6WfHHeemabvgyi8ihlTfZNybcXFzHI2I_TmU3NgD0Cm44",
    var transcription: String? = null,
    var sound: String? = null,
    var translations: MutableList<Translation>? = null,
    var nextDateRepeating: Date = DateProvider().getCurrentDateWithoutTime(),
    var countRepeat: Int = 0
) : Parcelable
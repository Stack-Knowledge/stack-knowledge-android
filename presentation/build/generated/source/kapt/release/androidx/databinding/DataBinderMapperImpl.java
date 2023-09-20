package androidx.databinding;

public class DataBinderMapperImpl extends MergedDataBinderMapper {
  DataBinderMapperImpl() {
    addMapper(new com.kdn.stack_knowledge_android.DataBinderMapperImpl());
  }
}

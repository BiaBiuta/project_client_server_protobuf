// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: competition.proto

// Protobuf Java Version: 4.26.1
/**
 * Protobuf type {@code SampleDTO}
 */package org.example.javaFiles;
public final class SampleDTO extends
    com.google.protobuf.GeneratedMessage implements
    // @@protoc_insertion_point(message_implements:SampleDTO)
    SampleDTOOrBuilder {
private static final long serialVersionUID = 0L;
  static {
    com.google.protobuf.RuntimeVersion.validateProtobufGencodeVersion(
      com.google.protobuf.RuntimeVersion.RuntimeDomain.PUBLIC,
      /* major= */ 4,
      /* minor= */ 26,
      /* patch= */ 1,
      /* suffix= */ "",
      SampleDTO.class.getName());
  }
  // Use SampleDTO.newBuilder() to construct.
  private SampleDTO(com.google.protobuf.GeneratedMessage.Builder<?> builder) {
    super(builder);
  }
  private SampleDTO() {
    id_ = "";
    sampleCategory_ = "";
    ageCategory_ = "";
  }

  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return CompetitionProtobuf.internal_static_SampleDTO_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return CompetitionProtobuf.internal_static_SampleDTO_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            SampleDTO.class, SampleDTO.Builder.class);
  }

  public static final int ID_FIELD_NUMBER = 1;
  @SuppressWarnings("serial")
  private volatile java.lang.Object id_ = "";
  /**
   * <code>string id = 1;</code>
   * @return The id.
   */
  @java.lang.Override
  public java.lang.String getId() {
    java.lang.Object ref = id_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      id_ = s;
      return s;
    }
  }
  /**
   * <code>string id = 1;</code>
   * @return The bytes for id.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getIdBytes() {
    java.lang.Object ref = id_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      id_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int SAMPLECATEGORY_FIELD_NUMBER = 2;
  @SuppressWarnings("serial")
  private volatile java.lang.Object sampleCategory_ = "";
  /**
   * <code>string sampleCategory = 2;</code>
   * @return The sampleCategory.
   */
  @java.lang.Override
  public java.lang.String getSampleCategory() {
    java.lang.Object ref = sampleCategory_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      sampleCategory_ = s;
      return s;
    }
  }
  /**
   * <code>string sampleCategory = 2;</code>
   * @return The bytes for sampleCategory.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getSampleCategoryBytes() {
    java.lang.Object ref = sampleCategory_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      sampleCategory_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int AGECATEGORY_FIELD_NUMBER = 3;
  @SuppressWarnings("serial")
  private volatile java.lang.Object ageCategory_ = "";
  /**
   * <code>string ageCategory = 3;</code>
   * @return The ageCategory.
   */
  @java.lang.Override
  public java.lang.String getAgeCategory() {
    java.lang.Object ref = ageCategory_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      ageCategory_ = s;
      return s;
    }
  }
  /**
   * <code>string ageCategory = 3;</code>
   * @return The bytes for ageCategory.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getAgeCategoryBytes() {
    java.lang.Object ref = ageCategory_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      ageCategory_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (!com.google.protobuf.GeneratedMessage.isStringEmpty(id_)) {
      com.google.protobuf.GeneratedMessage.writeString(output, 1, id_);
    }
    if (!com.google.protobuf.GeneratedMessage.isStringEmpty(sampleCategory_)) {
      com.google.protobuf.GeneratedMessage.writeString(output, 2, sampleCategory_);
    }
    if (!com.google.protobuf.GeneratedMessage.isStringEmpty(ageCategory_)) {
      com.google.protobuf.GeneratedMessage.writeString(output, 3, ageCategory_);
    }
    getUnknownFields().writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!com.google.protobuf.GeneratedMessage.isStringEmpty(id_)) {
      size += com.google.protobuf.GeneratedMessage.computeStringSize(1, id_);
    }
    if (!com.google.protobuf.GeneratedMessage.isStringEmpty(sampleCategory_)) {
      size += com.google.protobuf.GeneratedMessage.computeStringSize(2, sampleCategory_);
    }
    if (!com.google.protobuf.GeneratedMessage.isStringEmpty(ageCategory_)) {
      size += com.google.protobuf.GeneratedMessage.computeStringSize(3, ageCategory_);
    }
    size += getUnknownFields().getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof SampleDTO)) {
      return super.equals(obj);
    }
    SampleDTO other = (SampleDTO) obj;

    if (!getId()
        .equals(other.getId())) return false;
    if (!getSampleCategory()
        .equals(other.getSampleCategory())) return false;
    if (!getAgeCategory()
        .equals(other.getAgeCategory())) return false;
    if (!getUnknownFields().equals(other.getUnknownFields())) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + ID_FIELD_NUMBER;
    hash = (53 * hash) + getId().hashCode();
    hash = (37 * hash) + SAMPLECATEGORY_FIELD_NUMBER;
    hash = (53 * hash) + getSampleCategory().hashCode();
    hash = (37 * hash) + AGECATEGORY_FIELD_NUMBER;
    hash = (53 * hash) + getAgeCategory().hashCode();
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static SampleDTO parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static SampleDTO parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static SampleDTO parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static SampleDTO parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static SampleDTO parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static SampleDTO parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static SampleDTO parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseWithIOException(PARSER, input);
  }
  public static SampleDTO parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public static SampleDTO parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseDelimitedWithIOException(PARSER, input);
  }

  public static SampleDTO parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static SampleDTO parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseWithIOException(PARSER, input);
  }
  public static SampleDTO parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(SampleDTO prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessage.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code SampleDTO}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessage.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:SampleDTO)
      SampleDTOOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return CompetitionProtobuf.internal_static_SampleDTO_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return CompetitionProtobuf.internal_static_SampleDTO_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              SampleDTO.class, SampleDTO.Builder.class);
    }

    // Construct using SampleDTO.newBuilder()
    private Builder() {

    }

    private Builder(
        com.google.protobuf.GeneratedMessage.BuilderParent parent) {
      super(parent);

    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      bitField0_ = 0;
      id_ = "";
      sampleCategory_ = "";
      ageCategory_ = "";
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return CompetitionProtobuf.internal_static_SampleDTO_descriptor;
    }

    @java.lang.Override
    public SampleDTO getDefaultInstanceForType() {
      return SampleDTO.getDefaultInstance();
    }

    @java.lang.Override
    public SampleDTO build() {
      SampleDTO result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public SampleDTO buildPartial() {
      SampleDTO result = new SampleDTO(this);
      if (bitField0_ != 0) { buildPartial0(result); }
      onBuilt();
      return result;
    }

    private void buildPartial0(SampleDTO result) {
      int from_bitField0_ = bitField0_;
      if (((from_bitField0_ & 0x00000001) != 0)) {
        result.id_ = id_;
      }
      if (((from_bitField0_ & 0x00000002) != 0)) {
        result.sampleCategory_ = sampleCategory_;
      }
      if (((from_bitField0_ & 0x00000004) != 0)) {
        result.ageCategory_ = ageCategory_;
      }
    }

    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof SampleDTO) {
        return mergeFrom((SampleDTO)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(SampleDTO other) {
      if (other == SampleDTO.getDefaultInstance()) return this;
      if (!other.getId().isEmpty()) {
        id_ = other.id_;
        bitField0_ |= 0x00000001;
        onChanged();
      }
      if (!other.getSampleCategory().isEmpty()) {
        sampleCategory_ = other.sampleCategory_;
        bitField0_ |= 0x00000002;
        onChanged();
      }
      if (!other.getAgeCategory().isEmpty()) {
        ageCategory_ = other.ageCategory_;
        bitField0_ |= 0x00000004;
        onChanged();
      }
      this.mergeUnknownFields(other.getUnknownFields());
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      if (extensionRegistry == null) {
        throw new java.lang.NullPointerException();
      }
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            case 10: {
              id_ = input.readStringRequireUtf8();
              bitField0_ |= 0x00000001;
              break;
            } // case 10
            case 18: {
              sampleCategory_ = input.readStringRequireUtf8();
              bitField0_ |= 0x00000002;
              break;
            } // case 18
            case 26: {
              ageCategory_ = input.readStringRequireUtf8();
              bitField0_ |= 0x00000004;
              break;
            } // case 26
            default: {
              if (!super.parseUnknownField(input, extensionRegistry, tag)) {
                done = true; // was an endgroup tag
              }
              break;
            } // default:
          } // switch (tag)
        } // while (!done)
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.unwrapIOException();
      } finally {
        onChanged();
      } // finally
      return this;
    }
    private int bitField0_;

    private java.lang.Object id_ = "";
    /**
     * <code>string id = 1;</code>
     * @return The id.
     */
    public java.lang.String getId() {
      java.lang.Object ref = id_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        id_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string id = 1;</code>
     * @return The bytes for id.
     */
    public com.google.protobuf.ByteString
        getIdBytes() {
      java.lang.Object ref = id_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        id_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string id = 1;</code>
     * @param value The id to set.
     * @return This builder for chaining.
     */
    public Builder setId(
        java.lang.String value) {
      if (value == null) { throw new NullPointerException(); }
      id_ = value;
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }
    /**
     * <code>string id = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearId() {
      id_ = getDefaultInstance().getId();
      bitField0_ = (bitField0_ & ~0x00000001);
      onChanged();
      return this;
    }
    /**
     * <code>string id = 1;</code>
     * @param value The bytes for id to set.
     * @return This builder for chaining.
     */
    public Builder setIdBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) { throw new NullPointerException(); }
      checkByteStringIsUtf8(value);
      id_ = value;
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }

    private java.lang.Object sampleCategory_ = "";
    /**
     * <code>string sampleCategory = 2;</code>
     * @return The sampleCategory.
     */
    public java.lang.String getSampleCategory() {
      java.lang.Object ref = sampleCategory_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        sampleCategory_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string sampleCategory = 2;</code>
     * @return The bytes for sampleCategory.
     */
    public com.google.protobuf.ByteString
        getSampleCategoryBytes() {
      java.lang.Object ref = sampleCategory_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        sampleCategory_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string sampleCategory = 2;</code>
     * @param value The sampleCategory to set.
     * @return This builder for chaining.
     */
    public Builder setSampleCategory(
        java.lang.String value) {
      if (value == null) { throw new NullPointerException(); }
      sampleCategory_ = value;
      bitField0_ |= 0x00000002;
      onChanged();
      return this;
    }
    /**
     * <code>string sampleCategory = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearSampleCategory() {
      sampleCategory_ = getDefaultInstance().getSampleCategory();
      bitField0_ = (bitField0_ & ~0x00000002);
      onChanged();
      return this;
    }
    /**
     * <code>string sampleCategory = 2;</code>
     * @param value The bytes for sampleCategory to set.
     * @return This builder for chaining.
     */
    public Builder setSampleCategoryBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) { throw new NullPointerException(); }
      checkByteStringIsUtf8(value);
      sampleCategory_ = value;
      bitField0_ |= 0x00000002;
      onChanged();
      return this;
    }

    private java.lang.Object ageCategory_ = "";
    /**
     * <code>string ageCategory = 3;</code>
     * @return The ageCategory.
     */
    public java.lang.String getAgeCategory() {
      java.lang.Object ref = ageCategory_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        ageCategory_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string ageCategory = 3;</code>
     * @return The bytes for ageCategory.
     */
    public com.google.protobuf.ByteString
        getAgeCategoryBytes() {
      java.lang.Object ref = ageCategory_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        ageCategory_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string ageCategory = 3;</code>
     * @param value The ageCategory to set.
     * @return This builder for chaining.
     */
    public Builder setAgeCategory(
        java.lang.String value) {
      if (value == null) { throw new NullPointerException(); }
      ageCategory_ = value;
      bitField0_ |= 0x00000004;
      onChanged();
      return this;
    }
    /**
     * <code>string ageCategory = 3;</code>
     * @return This builder for chaining.
     */
    public Builder clearAgeCategory() {
      ageCategory_ = getDefaultInstance().getAgeCategory();
      bitField0_ = (bitField0_ & ~0x00000004);
      onChanged();
      return this;
    }
    /**
     * <code>string ageCategory = 3;</code>
     * @param value The bytes for ageCategory to set.
     * @return This builder for chaining.
     */
    public Builder setAgeCategoryBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) { throw new NullPointerException(); }
      checkByteStringIsUtf8(value);
      ageCategory_ = value;
      bitField0_ |= 0x00000004;
      onChanged();
      return this;
    }

    // @@protoc_insertion_point(builder_scope:SampleDTO)
  }

  // @@protoc_insertion_point(class_scope:SampleDTO)
  private static final SampleDTO DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new SampleDTO();
  }

  public static SampleDTO getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<SampleDTO>
      PARSER = new com.google.protobuf.AbstractParser<SampleDTO>() {
    @java.lang.Override
    public SampleDTO parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      Builder builder = newBuilder();
      try {
        builder.mergeFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(builder.buildPartial());
      } catch (com.google.protobuf.UninitializedMessageException e) {
        throw e.asInvalidProtocolBufferException().setUnfinishedMessage(builder.buildPartial());
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(e)
            .setUnfinishedMessage(builder.buildPartial());
      }
      return builder.buildPartial();
    }
  };

  public static com.google.protobuf.Parser<SampleDTO> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<SampleDTO> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public SampleDTO getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}


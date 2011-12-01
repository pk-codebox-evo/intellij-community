package com.jetbrains.python.debugger;

import com.intellij.openapi.util.SystemInfo;
import com.intellij.openapi.util.io.FileUtil;
import org.jetbrains.annotations.Nullable;

public abstract class PySourcePosition {

  private final String file;
  private final int line;

  protected PySourcePosition(final String file, final int line) {
    this.file = normalize(file);
    this.line = line;
  }

  @Nullable
  private static String normalize(@Nullable String file) {
    if (file == null) {
      return file;
    }
    String res =  FileUtil.toSystemIndependentName(file);
    if (SystemInfo.isWindows) {
      res = res.toLowerCase();
    }
    return res;
  }

  public String getFile() {
    return file;
  }

  public int getLine() {
    return line;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof PySourcePosition)) return false;

    PySourcePosition that = (PySourcePosition)o;

    if (line != that.line) return false;
    if (file != null ? !file.equals(that.file) : that.file != null) return false;

    return true;
  }

  @Override
  public int hashCode() {
    int result = file != null ? file.hashCode() : 0;
    result = 31 * result + line;
    return result;
  }

  @Override
  public String toString() {
    return "PySourcePosition(" + file + ":" + line + ")";
  }
}

////////////////////////////////////////////////////////////////////////////////
//
// Copyright (c) 2015, Suncorp Metway Limited. All rights reserved.
//
// This is unpublished proprietary source code of Suncorp Metway Limited.
// The copyright notice above does not evidence any actual or intended
// publication of such source code.
//
////////////////////////////////////////////////////////////////////////////////

package au.com.suncorp.easyshare.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import au.com.suncorp.easyshare.model.FileMetadata;

public interface FileMetadataRepository extends JpaRepository<FileMetadata, String> {

}

